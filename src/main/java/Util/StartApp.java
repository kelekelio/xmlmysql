package Util;

import XML.GeneralHandler;
import XML.ServerListHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class StartApp {

    //App starts
    //app goes through all server listed in servers.xml
    //for every server listed:
    //1. Set DB name
    //2. set path to the client
    //3. get client version
    //4. go through every xml file listed


    public static void start() throws ParserConfigurationException, SAXException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        ServerListHandler handler = new ServerListHandler();

        try {
            saxParser.parse(new File("src//main//resources//servers.xml"), handler);
        }
        catch (IOException io) {
            System.out.println("file not found.");
        }
    }



}
