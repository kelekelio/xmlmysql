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

    private LinkedHashMap<String, String> xmlMap = new LinkedHashMap<String, String>();
    private String tableName;
    private StringBuilder data = null;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public LinkedHashMap<String, String> getXmlMap() {
        return xmlMap;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase(tableName)) {
            try {
                DB.loadTableCreate(tableName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (qName.equalsIgnoreCase("id")) {
            xmlMap.put("id", null);
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("id")) {
            xmlMap.put("id", String.valueOf(data));
            System.out.println(data);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }



}
