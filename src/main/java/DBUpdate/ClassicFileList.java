package DBUpdate;

import CSV.CSVReader;
import XML.GeneralHandler;
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
public class ClassicFileList {

    public static void selectedFiles() throws IOException, SAXException, ParserConfigurationException {

        String folderName = "data_classic";

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
        consolidateList.clear();



        ignoreList.add("bound_radius");
        handler.setIgnoreList(ignoreList);
        handler.setTruncate(false);
        handler.setInitialNode("client_familiar");
        handler.setTableName("client_familiars");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\familiars.xml"), handler);
        ignoreList.clear();


        handler.setTruncate(false);
        handler.setInitialNode("client_ride_data");
        handler.setTableName("client_ride_datas");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\rides\\rides.xml"), handler);
        ignoreList.clear();



        CSVReader.readCSVClassic("D:\\PB\\" + folderName + "\\world\\source_sphere.csv");

        /*
        ignoreList.add("bonus_attrs");
        ignoreList.add("data");
        handler.setIgnoreList(ignoreList);
        handler.setTruncate(false);
        handler.setInitialNode("client_abyss_race_bonuss");
        handler.setTableName("client_abyss_race_bonus");
        saxParser.parse(new File("D:\\PB\\data\\pc\\abyss_race_bonuses.xml"), handler);

        handler.setInitialNode("client_pcraces");
        handler.setTableName("client_pcrace");
        saxParser.parse(new File("D:\\PB\\data\\pc\\client_PCRace.xml"), handler);

        handler.setInitialNode("client_item_collection_attrs");
        handler.setTableName("client_item_collection_attr");
        saxParser.parse(new File("D:\\PB\\data\\pc\\client_item_collection_attr.xml"), handler);

        handler.setInitialNode("client_jumping_quickbars");
        handler.setTableName("client_jumping_quickbar");
        saxParser.parse(new File("D:\\PB\\data\\pc\\client_jumping_quickbar.xml"), handler);

        handler.setInitialNode("client_ride_datas");
        handler.setTableName("client_ride_data");
        saxParser.parse(new File("D:\\PB\\data\\rides\\rides.xml"), handler);



        versionHandler.setRegion("kr");
        versionHandler.setInitialNode("client_ride_datas");
        versionHandler.setTableName("client_ride_data");
        saxParser.parse(new File("D:\\PB\\data\\rides\\rides.xml"), versionHandler);

        versionHandler.setRegion("eu");
        versionHandler.setInitialNode("client_ride_datas");
        versionHandler.setTableName("client_ride_data");
        saxParser.parse(new File("D:\\PB\\data\\rides\\rides.xml"), versionHandler);


        versionHandler.setRegion("kr");
        versionHandler.setInitialNode("client_items");
        versionHandler.setTableName("client_item");
        saxParser.parse(new File("D:/PB/data/items/client_items_etc_1.xml"), versionHandler);
        saxParser.parse(new File("D:/PB/data/items/client_items_etc_2.xml"), versionHandler);
        versionHandler.setRegion("eu");
        saxParser.parse(new File("D:/PB/data_eu/items/client_items_etc_2.xml"), versionHandler);

         */
    }
}
