package DBUpdate;

import CSV.CSVReader;
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
public class ClassicFileList {

    public static void selectedFiles(SAXParser saxParser, GeneralHandler handler, VersionHandler versionHandler, LanguageHandler languageHandler) throws IOException, SAXException, ParserConfigurationException {

        String folderName = "data_classic";



        //TODO: Items
        handler.setTruncate(false);
        handler.setInitialNode("client_item");
        handler.setTableName("client_items");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items.xml"), handler);


        DB.truncate("client_combine_recipe_expansion");
        handler.setTruncate(true);
        handler.setTableName("client_combine_recipes");
        handler.setInitialNode("client_combine_recipe");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_combine_recipe.xml"), handler);


        handler.setInitialNode("client_setitem");
        handler.setTableName("client_setitems");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_setitem.xml"), handler);


        //TODO: npcs
        //handler.setTruncate(false);
        handler.setInitialNode("client_npc_goodslist");
        handler.setTableName("client_npc_goodslists");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npc_goodslist.xml"), handler);


        //handler.setTruncate(false);
        handler.setInitialNode("client_npc_trade_in_list");
        handler.setTableName("client_npc_trade_in_lists");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npc_trade_in_list.xml"), handler);


        //handler.setTruncate(true);
        handler.setInitialNode("npc_client");
        handler.setTableName("npc_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs.xml"), handler);




        //TODO: Quests
        //handler.setTruncate(true); default
        handler.setInitialNode("quest");
        handler.setTableName("quests");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Quest\\quest.xml"), handler);


        //TODO: Skills
        //handler.setTruncate(true); default
        handler.setInitialNode("client_skill_learn");
        handler.setTableName("client_skill_learns");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\skills\\client_skill_learns.xml"), handler);


        handler.setInitialNode("skill_base_client");
        handler.setTableName("skill_base_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\skills\\client_skills.xml"), handler);



        //TODO: func_pet
        //handler.setTruncate(true); default
        handler.setInitialNode("client_toypet");
        handler.setTableName("client_toypets");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\toypets.xml"), handler);


        //TODO: Gather
        //handler.setTruncate(true); default
        handler.setInitialNode("gather_src");
        handler.setTableName("gather_srcs");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Gather\\gather_src.xml"), handler);


        //TODO: pc
        //handler.setTruncate(true); default
        handler.setInitialNode("client_achievement_action");
        handler.setTableName("client_achievement_actions");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\pc\\client_achievement_action.xml"), handler);

        //handler.setTruncate(true); default
        handler.setInitialNode("client_achievement_event");
        handler.setTableName("client_achievement_events");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\pc\\client_achievement_event.xml"), handler);

        //handler.setTruncate(true); default
        handler.setInitialNode("client_battlepass_reward");
        handler.setTableName("client_battlepass_rewards");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\pc\\client_battlepass_reward.xml"), handler);

        //handler.setTruncate(true); default
        handler.setInitialNode("client_battlepass_season");
        handler.setTableName("client_battlepass_seasons");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\pc\\client_battlepass_season.xml"), handler);

        //handler.setTruncate(true); default
        handler.setInitialNode("client_title");
        handler.setTableName("client_titles");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\pc\\client_titles.xml"), handler);


        //TODO: World
        handler.setInitialNode("client_instance_cooltime");
        handler.setTableName("client_instance_cooltimes");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\world\\client_instance_cooltime.xml"), handler);

        handler.setInitialNode("zonemap");
        handler.setTableName("zonemaps");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\world\\zonemap.xml"), handler);

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


        //TODO: CSV
        CSVReader.readCSVClassic("D:\\PB\\" + folderName + "\\world\\source_sphere.csv");




        //TODO: Versions
        versionHandler.setRegion("classic");
        versionHandler.setInitialNode("client_item");
        versionHandler.setTableName("client_items");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items.xml"), versionHandler);

        versionHandler.setInitialNode("skill_base_client");
        versionHandler.setTableName("skill_base_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\skills\\client_skills.xml"), versionHandler);

        versionHandler.setInitialNode("quest");
        versionHandler.setTableName("quests");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Quest\\quest.xml"), versionHandler);

        versionHandler.setInitialNode("npc_client");
        versionHandler.setTableName("npc_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs.xml"), versionHandler);

        versionHandler.setInitialNode("client_combine_recipe");
        versionHandler.setTableName("client_combine_recipes");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_combine_recipe.xml"), versionHandler);

    }
}
