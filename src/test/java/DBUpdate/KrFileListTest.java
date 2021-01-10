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
        DB.setiDbName("aion_c");
        DB.newInstance();
        ClassicFileList.selectedFiles();
    }

    @Test
    void updateKrDB () throws ParserConfigurationException, SAXException, IOException {
        DB.setiDbName("aion");
        DB.newInstance();
        KrFileList.selectedFiles();
    }

}