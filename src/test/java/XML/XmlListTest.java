package XML;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import DB.DB;

import static Extra.Colors.ANSI_RED;
import static Extra.Colors.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grzegorz Nowakowski
 */
class XmlListTest {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();

    GeneralHandler handler = new GeneralHandler();
    VersionHandler versionHandler = new VersionHandler();




    XmlListTest() throws ParserConfigurationException, SAXException {
    }

    @Test
    void updateFromASingleXML () throws SAXException, IOException {


        ArrayList<String> ignoreList = new ArrayList<>();

        ignoreList.add("bound_radius");
        handler.setIgnoreList(ignoreList);
        handler.setTruncate(false);
        handler.setInitialNode("client_familiar");
        handler.setTableName("client_familiars");
        saxParser.parse(new File("D:\\PB\\data\\func_pet\\familiars.xml"), handler);

        System.out.println(ANSI_RED + "There have been " + DB.getAlters() + " table alterations." + ANSI_RESET);
    }

}