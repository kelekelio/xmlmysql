package XML;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import DB.DB;
import com.google.common.base.Joiner;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import static Extra.Colors.*;

public class GeneralHandler extends DefaultHandler{

    IgnoreXmlNodeList ignoreXmlNodeList = new IgnoreXmlNodeList();
    private final ArrayList<String> ignoreList = ignoreXmlNodeList.getIgnoreList();

    ConsolidateXmlNodeList consolidateXmlNodeList = new ConsolidateXmlNodeList();
    private final ArrayList<String> consolidateList = consolidateXmlNodeList.getConsolidateList();

    ExtractXmlNodes extractXmlNodes = new ExtractXmlNodes();
    private final ArrayList<String> extractList = extractXmlNodes.getExtractList();


    private final LinkedHashMap<String, String> xmlMap = new LinkedHashMap<>();
    private final LinkedHashMap<String, String> xmlExtractedMap = new LinkedHashMap<>();
    private String tableName;
    private String initialNode;
    private StringBuilder data = null;
    private boolean truncate = true;
    private ArrayList<String> consolidateTemp = new ArrayList<String>();
    private String temporaryArrayNode = "";
    private boolean insideConsolidated = false;
    private String tempConsolidatedNodeName = "";
    private boolean insideCombineRecipeExpansion = false;
    private boolean insideExtractedNodes = false;
    private String tempExtractedNodeName = "";

    /*
        client_item_skill_enhances has dunble <data> nodes
        because we skip them, we need to store <enchant_prob> outside extracted nodes until closing xml node
     */
    private String tempEnchantProb = "";


    int i = 0;

    public void setInitialNode(String initialNode) {
        this.initialNode = initialNode;
    }

    public void setTruncate(boolean truncate) {
        this.truncate = truncate;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }




    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase(initialNode)) {
            if (i == 0 && truncate) {
                DB.truncate(tableName);
            }
            xmlMap.clear();
            i++;

            /*
            client_sacred_stone_levels has level attribute (value) inside the <level> tag, as this is the only occurrence of such tag, if was used
             */
            if (qName.equalsIgnoreCase("level") && tableName.equalsIgnoreCase("client_sacred_stone_levels")) {
                xmlMap.put("level", attributes.getValue("level"));
            }
        }
        else if (qName.equalsIgnoreCase(tableName)) {
            System.out.println(ANSI_PURPLE + "Settings: DB Truncate => " + truncate + ANSI_RESET);
        }
        else if (consolidateList.contains(qName)) {
            tempConsolidatedNodeName = qName;
            insideConsolidated = true;
        }
        else if (extractList.contains(qName)) {
            tempExtractedNodeName = qName;
            insideExtractedNodes = true;
            //xmlMap.put(qName, xmlMap.get("name"));
            xmlExtractedMap.put("name", xmlMap.get("name"));
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        //start of XML object (ID is always first), set ID without "" in value. could be removed
        if (qName.equalsIgnoreCase("id") && !tableName.equalsIgnoreCase("client_item_collection_levels")) {
            xmlMap.put("id", String.valueOf(data));
        }
        //end of a single XML object. Insert into DB
        else if (qName.equalsIgnoreCase(initialNode)) {

            if (tableName.equalsIgnoreCase("client_item_skill_enhances")) {
                xmlMap.put("enchant_prob", "\"" + tempEnchantProb + "\"");
            }

            try {
                DB.replace(xmlMap, tableName);
            } catch (IOException | SQLException ignored) {

            }
            System.out.println("Inserted " + i + " objects into the " + tableName + " table.");
            tempEnchantProb = "";
        }
        // end of xml. Set truncate to true, start i from 0
        else if (qName.equalsIgnoreCase(tableName)) {
            truncate = true;
            i = 0;
        }

        //end of all child nodes but inside the combine_recipe_expansion node
        else if (insideExtractedNodes) {
            //we are inside combine_recipe_expansion node.
            //every time a child is closed, </component_quantity>, push value to a new xmlCraftMap
            // after </data> child, insert xmlCraftMap into DB
            //on </combine_recipe_expansion> insideCombineRecipeExpansion = false
            if (qName.equalsIgnoreCase("data")) {
                try {
                    DB.insert(xmlExtractedMap, tableName + "_" + tempExtractedNodeName);
                } catch (IOException | SQLException ignored) {

                }
                System.out.println("Inserted " + i + " objects into the client_" + tempExtractedNodeName + " table.");

            } else if (qName.equalsIgnoreCase(tempExtractedNodeName)) {
                tempExtractedNodeName = "";
                insideExtractedNodes = false; // we are exiting extracted nodes
                xmlExtractedMap.clear();    // clearing the temporary extracted map
            } else {

                // mysql reserved words
                if ("index".equalsIgnoreCase(qName)) {
                    xmlExtractedMap.put("idx", "\"" + data + "\"");
                } else {
                    xmlExtractedMap.put(qName, "\"" + data + "\"");
                }

            }


        }

        //the end of consolidated nodes
        else if (consolidateList.contains(qName)) {
            xmlMap.put(tempConsolidatedNodeName, "\"" + Joiner.on(";").join(consolidateTemp) + "\"");
            tempConsolidatedNodeName = "";
            insideConsolidated = false;
            consolidateTemp.clear();
        }

        //end of data node. push temporary string to consolidate array
        else if (qName.equalsIgnoreCase("data") && !insideCombineRecipeExpansion ) {
            consolidateTemp.add(temporaryArrayNode);
            temporaryArrayNode = "";
        }

        // Node appears in the ignore list. Do nothing
        else if (ignoreList.contains(qName) || qName.equalsIgnoreCase("dev_name")) {

        }

        else {
            //TODO: list of MYSQL reserved words
            if ("condition".equalsIgnoreCase(qName)) {
                xmlMap.put("conditions", "\"" + data + "\"");
            } else if ("delete".equalsIgnoreCase(qName)) {
                xmlMap.put("delete_", "\"" + data + "\"");
            } else if ("repeat".equalsIgnoreCase(qName)) {
                xmlMap.put("repeats", "\"" + data + "\"");
            } else if ("index".equalsIgnoreCase(qName)) {
                xmlMap.put("index_", "\"" + data + "\"");
            } else if ("desc".equalsIgnoreCase(qName)) {
                xmlMap.put("description", "\"" + data + "\"");
            } else if ("dir".equalsIgnoreCase(qName)) {
                xmlMap.put("dir", "\"" + data.toString().replaceAll("\\\\", "/") + "\"");
            } else if ("enchant_prob".equalsIgnoreCase(qName) && tableName.equalsIgnoreCase("client_item_skill_enhances") && !insideExtractedNodes) {
                //we are storing enchant_prob until closing xml node
                tempEnchantProb = tempEnchantProb + data + " ";
            }
            // inside consolidated node. put each node value into a temporary string
            else if (insideConsolidated
                    && !qName.equalsIgnoreCase("buy_price_rate")
                    && !qName.equalsIgnoreCase("buy_price_rate2")
                    && !qName.equalsIgnoreCase("sell_price_rate")
                    && !qName.equalsIgnoreCase("sell_price_rate2")
                    && !qName.equalsIgnoreCase("ap_buy_price_rate")
                    && !qName.equalsIgnoreCase("ap_buy_price_rate2")
                ) {
                temporaryArrayNode = temporaryArrayNode + data + " ";
            }
            else {
                if (data.toString().equalsIgnoreCase("true")) {
                    xmlMap.put(qName, "1");
                } else if (data.toString().equalsIgnoreCase("false")) {
                    xmlMap.put(qName, "0");
                }else {
                    xmlMap.put(qName, "\"" + data + "\"");
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }



}
