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


        //Quest
        handler.setTruncate(true);
        handler.setInitialNode("quest");
        handler.setTableName("quests");
        saxParser.parse(new File("D:\\Aion PKG\\data_1.20.1203\\quest\\quest.xml"), handler);
    }

    @Test
    void updateKoreanItemList () throws SAXException, IOException, ParserConfigurationException {


        String folderName = "data";
        DB.setiDbName("aion");
        DB.newInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();

        handler.setTruncate(false);
        handler.setInitialNode("client_item");
        handler.setTableName("client_items");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items_etc_1.xml"), handler);

        handler.setTruncate(false);
        handler.setInitialNode("client_item");
        handler.setTableName("client_items");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items_etc_2.xml"), handler);

        handler.setTruncate(false);
        handler.setInitialNode("client_item");
        handler.setTableName("client_items");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items_armor_1.xml"), handler);

        handler.setTruncate(false);
        handler.setInitialNode("client_item");
        handler.setTableName("client_items");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items_armor_2.xml"), handler);

        handler.setTruncate(false);
        handler.setInitialNode("client_item");
        handler.setTableName("client_items");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items_misc.xml"), handler);


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

    @Test
    void updateClassicItemList () throws SAXException, IOException, ParserConfigurationException {
        String folderName = "data_classic";
        DB.setiDbName("aion_c");
        DB.newInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();

        handler.setTruncate(false);
        handler.setInitialNode("client_item");
        handler.setTableName("client_items");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items.xml"), handler);
    }

    @Test
    void updateFromSingleXML () throws SAXException, IOException, ParserConfigurationException {
        String folderName = "data";
        DB.setiDbName("aion");
        DB.newInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();

        //handler.setTruncate(true);
        //handler.setTableName("client_equipment_skills");
        //handler.setInitialNode("client_equipment_skill");
        //saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_equipment_skill.xml"), handler);



        DB.truncate("polish_bonus_setlists_random_attr_group_list");
        handler.setTruncate(true);
        handler.setTableName("polish_bonus_setlists");
        handler.setInitialNode("polish_bonus_setlist");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\polish_bonus_setlist.xml"), handler);
    }


    @Test
    void updateAllLanguagesClassic () throws ParserConfigurationException, SAXException, IOException {

        String folderName = "data_classic";
        DB.setiDbName("aion_c");
        DB.newInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();

        //TODO: Strings
        languageHandler.setColumnName("body");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_bm.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_bmrestrict.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_dic_etc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_dic_item.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_dic_monster.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_dic_people.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_dic_place.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_etc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_funcpet.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_gossip.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_item.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_item2.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_level.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_monster.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_msg.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_npc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_quest.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_skill.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_ui.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_url.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\StringTable_Dialog.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\stringtable_tip.xml"), languageHandler);

        //TODO: EN
        languageHandler.setColumnName("LAN_EN");
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_bm.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_bmrestrict.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_dic_etc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_dic_item.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_dic_monster.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_dic_people.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_dic_place.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_etc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_funcpet.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_gossip.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_item.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_item2.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_level.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_monster.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_msg.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_npc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_quest.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_skill.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_ui.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_url.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\StringTable_Dialog.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\stringtable_tip.xml"), languageHandler);


    }

    @Test
    void updateAllLanguagesKr () throws ParserConfigurationException, SAXException, IOException {

        String folderName = "data";
        DB.setiDbName("aion");
        DB.newInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();


        //TODO: Strings
        languageHandler.setColumnName("body");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_bm.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_bmrestrict.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_dic_etc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_dic_item.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_dic_monster.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_dic_people.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_dic_place.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_etc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_funcpet.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_gossip.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_item.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_item2.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_item3.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_item4.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_level.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_monster.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_msg.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_npc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_quest.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_skill.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_ui.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\client_strings_url.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\StringTable_Dialog.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Strings\\stringtable_tip.xml"), languageHandler);

        //TODO: EN
        languageHandler.setColumnName("LAN_EN");
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_bm.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_bmrestrict.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_dic_etc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_dic_item.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_dic_monster.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_dic_people.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_dic_place.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_etc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_funcpet.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_gossip.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_item.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_item2.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_item3.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_item4.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_level.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_monster.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_msg.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_npc.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_quest.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_skill.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_ui.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\client_strings_url.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\StringTable_Dialog.xml"), languageHandler);
        saxParser.parse(new File("D:\\PB\\translations\\en\\strings\\stringtable_tip.xml"), languageHandler);


    }

}