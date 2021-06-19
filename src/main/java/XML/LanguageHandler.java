package XML;

import DB.DB;
import com.google.common.base.Joiner;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static Extra.Colors.ANSI_PURPLE;
import static Extra.Colors.ANSI_RESET;

/**
 * @author Grzegorz Nowakowski
 */
public class LanguageHandler extends DefaultHandler {

    private StringBuilder data = null;
    private int i = 0;
    private final LinkedHashMap<String, String> xmlMap = new LinkedHashMap<>();
    private String columnName;

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("string")) {
            xmlMap.clear();
            i++;
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
        else if (qName.equalsIgnoreCase("string")) {
            try {
                DB.updateOnDupliacteKey(xmlMap, columnName);
            } catch (IOException | SQLException ignored) {

            }
            //System.out.println("Inserted " + i + " translations into the translation table.");
        }

        // end of xml. Set truncate to true; clear ignore list, start i from 0
        else if (qName.equalsIgnoreCase("strings")) {
            i = 0;
        }
        else if (qName.equalsIgnoreCase("body")) {
            xmlMap.put("ko", "\'" + data.toString().replaceAll("'", "&apos;") + "\'");
        }else if (qName.equalsIgnoreCase("name")) {
            xmlMap.put(qName, "\"" + data + "\"");
        }else {
            //do nothing
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

}
