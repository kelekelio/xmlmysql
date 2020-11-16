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
    void updateFromASingleXML () throws SAXException, IOException, ParserConfigurationException {


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

        consolidateList.add("fighter_selectable_item");
        consolidateList.add("knight_selectable_item");
        consolidateList.add("ranger_selectable_item");
        consolidateList.add("assassin_selectable_item");
        consolidateList.add("wizard_selectable_item");
        consolidateList.add("elementalist_selectable_item");
        consolidateList.add("priest_selectable_item");
        consolidateList.add("chanter_selectable_item");
        consolidateList.add("gunner_selectable_item");
        consolidateList.add("rider_selectable_item");
        consolidateList.add("painter_selectable_item");
        handler.setConsolidateList(consolidateList);
        //ignoreList.add("data");
        ignoreList.add("fighter_selectable_reward");
        ignoreList.add("knight_selectable_reward");
        ignoreList.add("ranger_selectable_reward");
        ignoreList.add("assassin_selectable_reward");
        ignoreList.add("wizard_selectable_reward");
        ignoreList.add("elementalist_selectable_reward");
        ignoreList.add("priest_selectable_reward");
        ignoreList.add("chanter_selectable_reward");
        ignoreList.add("gunner_selectable_reward");
        ignoreList.add("rider_selectable_reward");
        ignoreList.add("painter_selectable_reward");
        handler.setIgnoreList(ignoreList);
        handler.setTruncate(true);
        handler.setInitialNode("quest");
        handler.setTableName("quests");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Quest\\quest.xml"), handler);
        ignoreList.clear();
    }

}