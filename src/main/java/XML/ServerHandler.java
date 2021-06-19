package XML;

import DB.DB;
import com.google.common.base.Strings;
import org.xml.sax.SAXException;
import servers.GameXmlFile;
import servers.Server;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ServerHandler {
    private Server server;

    public ServerHandler() {
    }

    public ServerHandler(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void update() throws ParserConfigurationException, SAXException {
        DB.setiDbName(server.getDbName());
        DB.newInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();

        versionHandler.setVersion(server.getClientVersion());


        for(GameXmlFile file : server.getXmlFiles()) {
            handler.setInitialNode(file.getInitialNode());
            handler.setTableName(file.getTableName());
            handler.setTruncate(file.isTruncate());

            if (file.getLang() != null) {
                languageHandler.setColumnName(file.getLang());

                if (file.getLang().equalsIgnoreCase("ko")) {
                    try {
                        saxParser.parse(new File(server.getClientPath() + "\\data_" + server.getClientVersion() + file.getPath()), languageHandler);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        saxParser.parse(new File("D:\\PB\\translations\\" + server.getDbName() + "\\" + file.getLang() + file.getPath()), languageHandler);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                try {
                    saxParser.parse(new File(server.getClientPath() + "\\data_" + server.getClientVersion() + "\\" + file.getPath()), handler);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (file.isVersions()) {
                    versionHandler.setInitialNode(file.getInitialNode());
                    versionHandler.setTableName(file.getTableName());

                    try {
                        saxParser.parse(new File(server.getClientPath() + "\\data_" + server.getClientVersion() + "\\" + file.getPath()), versionHandler);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }



        }

    }

}
