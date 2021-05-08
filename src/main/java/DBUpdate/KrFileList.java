package DBUpdate;

import DB.DB;
import XML.GeneralHandler;
import XML.LanguageHandler;
import XML.VersionHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Grzegorz Nowakowski
 */
public class KrFileList {

    public static void selectedFiles(SAXParser saxParser, GeneralHandler handler, VersionHandler versionHandler, LanguageHandler languageHandler) throws IOException, SAXException, ParserConfigurationException {

        String folderName = "data";


        //TODO: Items

        //TODO: NPC

        //TODO: PC

        //TODO: Achievements

        //TODO: func_pet

        //TODO: Gather

        //TODO: Housing

        //TODO: Luna






        //TODO: 8.0 Lord's Relic
        handler.setTruncate(true);
        handler.setTableName("client_sacred_stone_levels");
        handler.setInitialNode("level");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\SacredStone\\client_sacred_stone_level.xml"), handler);


    }
}
