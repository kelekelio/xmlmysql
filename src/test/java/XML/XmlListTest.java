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
    void updateFromQuestXML () throws SAXException, IOException, ParserConfigurationException {


        String folderName = "data_classic";
        DB.setiDbName("aion_c");
        DB.newInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();

        ArrayList<String> ignoreList = new ArrayList<>();
        ArrayList<String> consolidateList = new ArrayList<>();


        //Quest

        consolidateList.add("fighter_selectable_reward");
        consolidateList.add("knight_selectable_reward");
        consolidateList.add("ranger_selectable_reward");
        consolidateList.add("assassin_selectable_reward");
        consolidateList.add("wizard_selectable_reward");
        consolidateList.add("elementalist_selectable_reward");
        consolidateList.add("priest_selectable_reward");
        consolidateList.add("chanter_selectable_reward");
        consolidateList.add("gunner_selectable_reward");
        consolidateList.add("rider_selectable_reward");
        consolidateList.add("painter_selectable_reward");
        handler.setConsolidateList(consolidateList);
        handler.setTruncate(true);
        handler.setInitialNode("quest");
        handler.setTableName("quests");
        saxParser.parse(new File("D:\\Aion PKG\\data_1.20.1203\\quest\\quest.xml"), handler);
    }

    @Test
    void updateFromSingleXML () throws SAXException, IOException, ParserConfigurationException {


        String folderName = "data_classic";
        DB.setiDbName("aion_c");
        DB.newInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();

        ArrayList<String> ignoreList = new ArrayList<>();
        ArrayList<String> consolidateList = new ArrayList<>();


        versionHandler.setRegion("classic");
        versionHandler.setInitialNode("client_item");
        versionHandler.setTableName("client_items");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items.xml"), versionHandler);


        /*
        consolidateList.add("trade_in_item_list");
        handler.setConsolidateList(consolidateList);
        //ignoreList.add("data");
        handler.setIgnoreList(ignoreList);
        handler.setTruncate(false);
        handler.setInitialNode("client_item");
        handler.setTableName("client_items");
        saxParser.parse(new File("D:\\Aion PKG\\data_1.20.1203\\items\\client_items.xml"), handler);

         */
    }

}