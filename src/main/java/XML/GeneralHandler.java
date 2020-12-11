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

    private final LinkedHashMap<String, String> xmlMap = new LinkedHashMap<>();
    private String tableName;
    private ArrayList<String> ignoreList = new ArrayList<>();
    private ArrayList<String> consolidateList = new ArrayList<>();
    private String initialNode;
    private StringBuilder data = null;
    private boolean truncate = true;
    private ArrayList<String> consolidateTemp = new ArrayList<String>();
    private String temporaryArrayNode = "";
    private boolean insideConsolidated = false;
    private String tempConsolidatedNodeName = "";


    int i = 0;

    public void setConsolidateList(ArrayList<String> consolidateList) {
        this.consolidateList = consolidateList;
    }

    public void setIgnoreList(ArrayList<String> ignoreList) {
        this.ignoreList = ignoreList;
    }

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

                try {
                    DB.truncate(tableName);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            xmlMap.clear();
            i++;
        }
        else if (qName.equalsIgnoreCase(tableName)) {
            System.out.println(ANSI_PURPLE + "Settings: Ignore => " + ignoreList + ", DB Truncate => " + truncate + ANSI_RESET);
        }
        else if (consolidateList.contains(qName)) {
            tempConsolidatedNodeName = qName;
            insideConsolidated = true;
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        //start of XML object (ID is always first), set ID without "" in value. could be removed
        if (qName.equalsIgnoreCase("id")) {
            xmlMap.put("id", String.valueOf(data));
        }
        //end of a single XML object. Insert into DB
        else if (qName.equalsIgnoreCase(initialNode)) {
            try {
                DB.replace(xmlMap, tableName);
            } catch (IOException | SQLException ignored) {

            }
            System.out.println("Inserted " + i + " objects into the " + tableName + " table.");
        }
        // end of xml. Set truncate to true; clear ignore list, start i from 0
        else if (qName.equalsIgnoreCase(tableName)) {
            truncate = true;
            ignoreList.clear();
            consolidateList.clear();

            i = 0;
        }

        //
        else if (consolidateList.contains(qName)) {
            xmlMap.put(tempConsolidatedNodeName, "\"" + Joiner.on(";").join(consolidateTemp) + "\"");
            tempConsolidatedNodeName = "";
            insideConsolidated = false;
            consolidateTemp.clear();
        }

        //end of data node. push temporary string to consolidate array
        else if (qName.equalsIgnoreCase("data")) {
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
            } else if ("desc".equalsIgnoreCase(qName)) {
                xmlMap.put("description", "\"" + data + "\"");
            }
            // inside consolidated node. put each node value into a temporary string
            else if (insideConsolidated && !qName.equalsIgnoreCase("buy_price_rate")&& !qName.equalsIgnoreCase("sell_price_rate")) {
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
