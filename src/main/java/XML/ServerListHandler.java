package XML;

import CSV.CSVReader;
import DB.DB;
import com.google.common.base.Strings;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import servers.GameXmlFile;
import servers.Server;
import DLL.DLL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServerListHandler extends DefaultHandler {
    private StringBuilder data = null;
    private Server server;
    private GameXmlFile xml;
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();

    GeneralHandler handler = new GeneralHandler();
    VersionHandler versionHandler = new VersionHandler();
    LanguageHandler languageHandler = new LanguageHandler();

    ServerHandler serverHandler = new ServerHandler();

    public ServerListHandler() throws ParserConfigurationException, SAXException {
    }

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
        } else if (qName.equalsIgnoreCase("truncate_before")) {

            String[] truncateBefore = String.valueOf(data).split(", ");

            for (String truncate : truncateBefore) {
                DB.truncate(truncate);
            }



        } else if (qName.equalsIgnoreCase("path")) {
            xml.setPath(String.valueOf(data));
        } else if (qName.equalsIgnoreCase("initial_node")) {
            xml.setInitialNode(String.valueOf(data));
        } else if (qName.equalsIgnoreCase("table_name")) {
            xml.setTableName(String.valueOf(data));
        } else if (qName.equalsIgnoreCase("truncate")) {
            xml.setTruncate(Boolean.parseBoolean(String.valueOf(data)));
        } else if (qName.equalsIgnoreCase("versions")) {
            xml.setVersions(Boolean.parseBoolean(String.valueOf(data)));
        } else if (qName.equalsIgnoreCase("lang")) {
            xml.setLang(String.valueOf(data));
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


            //Point where we have the whole server obj
            serverHandler.setServer(server);
            try {
                serverHandler.update();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}
