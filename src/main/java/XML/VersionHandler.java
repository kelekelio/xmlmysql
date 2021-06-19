package XML;

import DB.DB;
import DLL.DLL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import static Extra.Colors.ANSI_PURPLE;
import static Extra.Colors.ANSI_RESET;

public class VersionHandler extends DefaultHandler {

    private final LinkedHashMap<String, String> xmlMap = new LinkedHashMap<>();
    private String tableName;
    private String version;
    private String initialNode;
    private StringBuilder data = null;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName + "_version";
    }

    public void setInitialNode(String initialNode) {
        this.initialNode = initialNode;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase(initialNode)) {
            //declare to maintain order
            xmlMap.put("id", null);
            xmlMap.put("name", null);
            xmlMap.put("client_version", "\"" + version + "\"");
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("id")) {

            xmlMap.put("id", String.valueOf(data));

        }
        else if (qName.equalsIgnoreCase(initialNode)) {
            try {
                DB.insertIgnoreError(xmlMap, tableName);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
        else if (qName.equalsIgnoreCase("name")) {
            xmlMap.put("name", "\"" + data + "\"");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

}
