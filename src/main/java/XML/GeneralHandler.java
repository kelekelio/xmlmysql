package XML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import DB.DB;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GeneralHandler extends DefaultHandler{

    private final LinkedHashMap<String, String> xmlMap = new LinkedHashMap<String, String>();
    private String tableName;
    private ArrayList<String> ignoreList = new ArrayList<>();
    private String initialNode;
    private StringBuilder data = null;
    private boolean truncate = true;

    int i = 0;

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





    public LinkedHashMap<String, String> getXmlMap() {
        return xmlMap;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase(tableName)) {
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
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("id")) {
            xmlMap.put("id", String.valueOf(data));
        }
        else if (qName.equalsIgnoreCase(tableName)) {
            try {
                DB.insert(xmlMap, tableName);
            } catch (IOException e) {

            }
            System.out.println("Inserted " + i + " objects to the DB.");
        }
        else if (qName.equalsIgnoreCase(initialNode)) {
            truncate = true;
            ignoreList.clear();
        }
        else if (ignoreList.contains(qName)) {

        }
        else {
            //TODO: list of MYSQL reserved words
            if ("condition".equalsIgnoreCase(qName)) {
                xmlMap.put("conditions", "\"" + data + "\"");
            }else {
                xmlMap.put(qName, "\"" + data + "\"");
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }



}
