package XML;

import DB.DB;
import DLL.DLL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.io.IOException;

import static Extra.Colors.ANSI_PURPLE;
import static Extra.Colors.ANSI_RESET;

public class VersionHandler extends GeneralHandler {

    private String region = "kr";
    private String tableName;
    private final String version = DLL.DllVersionCheck(region);
    private String initialNode;
    private boolean truncate = false;
    int i = 0;
    private StringBuilder data = null;

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void setInitialNode(String initialNode) {
        this.initialNode = initialNode;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase(tableName)) {
            i++;
        }
        else if (qName.equalsIgnoreCase(initialNode)) {
            System.out.println(ANSI_PURPLE + "Settings: Ignore => , DB Truncate => " + truncate + ANSI_RESET);
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("id")) {
            DB.execute("INSERT INTO " + tableName + "_version (id, version) VALUES (" + data + ", \"" + version + "\");");
            System.out.println("Inserted " + i + " objects into the " + tableName + " table.");
        }
        else if (qName.equalsIgnoreCase(initialNode)) {
            i = 0;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

}
