package DBUpdate;

import DB.DB;
import XML.GeneralHandler;
import XML.LanguageHandler;
import XML.VersionHandler;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grzegorz Nowakowski
 */
class KrFileListTest {

    @Test
    void updateClassicDB () throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();

        DB.setiDbName("aion_c");
        DB.newInstance();
        ClassicFileList.selectedFiles(saxParser, handler, versionHandler, languageHandler);
    }

    @Test
    void updateKrDB () throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();

        DB.setiDbName("aion");
        DB.newInstance();
        KrFileList.selectedFiles(saxParser, handler, versionHandler, languageHandler);
    }

}