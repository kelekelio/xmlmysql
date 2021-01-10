package DBUpdate;

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
public class EuFileList {

    public static void selectedFiles() throws IOException, SAXException, ParserConfigurationException {

        String folderName = "data_eu";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();


    }
}
