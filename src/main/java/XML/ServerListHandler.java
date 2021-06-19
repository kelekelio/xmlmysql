package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import servers.GameXmlFile;
import servers.Server;
import DLL.DLL;

import java.util.ArrayList;

public class ServerListHandler extends DefaultHandler {
    private StringBuilder data = null;
    private Server server;
    private GameXmlFile xml;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("server")) {
            server = new Server();
        } else if (qName.equalsIgnoreCase("file")) {
            xml = new GameXmlFile();
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("id")) {
            server.setId(Integer.valueOf(String.valueOf(data)));
        } else if (qName.equalsIgnoreCase("db_name")) {
            server.setDbName(String.valueOf(data));
        } else if (qName.equalsIgnoreCase("client_path")) {
            server.setClientPath(String.valueOf(data));
            server.setClientVersion(DLL.checkDllVersion(String.valueOf(data)));
        } else if (qName.equalsIgnoreCase("path")) {
            xml.setPath(String.valueOf(data));
        } else if (qName.equalsIgnoreCase("initial_node")) {
            xml.setInitialNode(String.valueOf(data));
        } else if (qName.equalsIgnoreCase("table_name")) {
            xml.setTableName(String.valueOf(data));
        } else if (qName.equalsIgnoreCase("truncate")) {
            xml.setTruncate(Boolean.parseBoolean(String.valueOf(data)));
        } else if (qName.equalsIgnoreCase("file")) {
            //add xmlfile to the list
            ArrayList<GameXmlFile> list = server.getXmlFiles();
            System.out.println(xml.getPath());
            list.add(xml);
            server.setXmlFiles(list);
            //reset xml
        } else if (qName.equalsIgnoreCase("server")) {
            System.out.println("Server ID: " + server.getId());
            System.out.println("Server db_name: " + server.getDbName());
            System.out.println("Server client_path: " + server.getClientPath());
            System.out.println("Server clientVersion: " + server.getClientVersion());

            for(GameXmlFile file : server.getXmlFiles())
            {
                System.out.println(
                        "File path: " + file.getPath() +
                        ", initial_node: " + file.getInitialNode()  +
                        ", table_name: " + file.getTableName() +
                        ", truncate: " + file.isTruncate()
                );
            }


            //Point where we have a whole server obj




        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}
