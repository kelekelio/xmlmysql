package DBUpdate;

import CSV.CSVReader;
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

    public static void selectedFiles() throws IOException, SAXException, ParserConfigurationException {

        String folderName = "data_classic";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();

        ArrayList<String> ignoreList = new ArrayList<>();
        ArrayList<String> consolidateList = new ArrayList<>();


        /*
        //TODO: Items
        consolidateList.add("trade_in_item_list");
        handler.setConsolidateList(consolidateList);
        handler.setTruncate(false);
        handler.setInitialNode("client_item");
        handler.setTableName("client_items");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items.xml"), handler);

        handler.setInitialNode("client_combine_recipe");
        handler.setTableName("client_combine_recipes");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_combine_recipe.xml"), handler);

        handler.setInitialNode("client_setitem");
        handler.setTableName("client_setitems");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_setitem.xml"), handler);


        //TODO: npcs
        consolidateList.add("goods_list");
        handler.setConsolidateList(consolidateList);
        //handler.setTruncate(false);
        handler.setInitialNode("client_npc_goodslist");
        handler.setTableName("client_npc_goodslists");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npc_goodslist.xml"), handler);

        consolidateList.add("goods_list");
        handler.setConsolidateList(consolidateList);
        //handler.setTruncate(false);
        handler.setInitialNode("client_npc_trade_in_list");
        handler.setTableName("client_npc_trade_in_lists");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npc_trade_in_list.xml"), handler);

        ignoreList.add("bound_radius");
        ignoreList.add("tab_list");
        ignoreList.add("appearance");
        ignoreList.add("visible_equipments");
        consolidateList.add("extra_currency_trade_info");
        consolidateList.add("trade_info");
        consolidateList.add("trade_in_trade_info");
        consolidateList.add("abyss_trade_info");
        consolidateList.add("coupon_trade_info");
        handler.setIgnoreList(ignoreList);
        handler.setConsolidateList(consolidateList);
        //handler.setTruncate(true);
        handler.setInitialNode("npc_client");
        handler.setTableName("npc_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs.xml"), handler);




        //TODO: Quests
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
        //handler.setTruncate(true); default
        handler.setInitialNode("quest");
        handler.setTableName("quests");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Quest\\quest.xml"), handler);


        //TODO: Skills
        //handler.setTruncate(true); default
        handler.setInitialNode("client_skill_learn");
        handler.setTableName("client_skill_learns");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\skills\\client_skill_learns.xml"), handler);

        ignoreList.add("fire_fx_bone");
        ignoreList.add("hit_fx");
        ignoreList.add("hit_fx_bone");
        ignoreList.add("fire_fx");
        ignoreList.add("cast_fx_bone");
        ignoreList.add("cast_fx");
        ignoreList.add("remaining_fx");
        ignoreList.add("need_fx");
        ignoreList.add("ammo_fxc");
        ignoreList.add("hit_camera_work");
        ignoreList.add("cast_camera_work");
        ignoreList.add("hit_fx_ex1");
        ignoreList.add("ammo_fx");
        ignoreList.add("ammo_fx_type");
        ignoreList.add("ammo_bone");
        ignoreList.add("ammo_speed");
        ignoreList.add("hit_fx_attacker_oriented");
        ignoreList.add("status_fx");
        ignoreList.add("status_fx_slot");
        ignoreList.add("status_fx_bone");
        ignoreList.add("hit_fx_ex3");
        ignoreList.add("interval_hit_fx_bone");
        ignoreList.add("interval_hit_fx");
        ignoreList.add("pre_fx_delay");
        ignoreList.add("pre_fx_bone");
        ignoreList.add("pre_fx");
        ignoreList.add("hit_fx_ex5");
        ignoreList.add("hit_fx_ex4");
        ignoreList.add("hit_fx_ex2");
        ignoreList.add("reflect_fx");
        ignoreList.add("status_shader");
        ignoreList.add("aura_fx_bone");
        ignoreList.add("aura_fx");
        ignoreList.add("aura_fx_slot");
        ignoreList.add("status_sfx1");
        ignoreList.add("sfx1");
        ignoreList.add("castcancel_fx");
        ignoreList.add("castcancel_fx_bone");
        ignoreList.add("fire_fxc");
        ignoreList.add("cast_fxc");
        ignoreList.add("hit_fxc");
        ignoreList.add("trail_tex");
        ignoreList.add("hit_target_camera_shake");
        ignoreList.add("hit_camera_shake");
        handler.setIgnoreList(ignoreList);
        handler.setInitialNode("skill_base_client");
        handler.setTableName("skill_base_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\skills\\client_skills.xml"), handler);



        //TODO: func_pet
        ignoreList.add("react_praise_d_better_desc02");
        ignoreList.add("react_praise_d_better_desc01");
        ignoreList.add("react_train_b_better_desc02");
        ignoreList.add("react_train_b_better_desc01");
        ignoreList.add("react_praise_b_better_desc01");
        ignoreList.add("react_praise_b_better_desc02");
        ignoreList.add("ask_whining_desc");
        ignoreList.add("react_play_d_better_desc01");
        ignoreList.add("react_care_b_better_desc01");
        ignoreList.add("react_play_d_better_desc02");
        ignoreList.add("react_care_b_better_desc02");
        ignoreList.add("react_praise_a_better_desc02");
        ignoreList.add("react_praise_a_better_desc01");
        ignoreList.add("react_train_a_better_desc01");
        ignoreList.add("react_care_a_better_desc02");
        ignoreList.add("react_train_a_better_desc02");
        ignoreList.add("react_care_a_better_desc01");
        ignoreList.add("react_train_a_good_desc02");
        ignoreList.add("react_train_b_good_desc02");
        ignoreList.add("react_train_b_good_desc01");
        ignoreList.add("react_care_a_good_desc02");
        ignoreList.add("react_train_d_good_desc02");
        ignoreList.add("react_care_a_good_desc01");
        ignoreList.add("react_train_c_good_desc01");
        ignoreList.add("react_train_d_good_desc01");
        ignoreList.add("react_train_c_good_desc02");
        ignoreList.add("react_care_c_good_desc02");
        ignoreList.add("react_praise_critical_desc01");
        ignoreList.add("react_care_b_good_desc01");
        ignoreList.add("react_care_c_good_desc01");
        ignoreList.add("react_care_b_good_desc02");
        ignoreList.add("react_train_critical_desc01");
        ignoreList.add("react_train_critical_desc02");
        ignoreList.add("react_play_d_good_desc01");
        ignoreList.add("react_play_d_good_desc02");
        ignoreList.add("react_play_c_good_desc01");
        ignoreList.add("react_play_c_good_desc02");
        ignoreList.add("react_play_b_good_desc02");
        ignoreList.add("react_play_a_good_desc01");
        ignoreList.add("react_play_b_good_desc01");
        ignoreList.add("react_care_d_good_desc01");
        ignoreList.add("react_praise_critical_desc02");
        ignoreList.add("react_play_a_good_desc02");
        ignoreList.add("react_care_d_good_desc02");
        ignoreList.add("react_praise_c_better_desc02");
        ignoreList.add("react_praise_c_better_desc01");
        ignoreList.add("react_play_critical_desc02");
        ignoreList.add("react_train_c_better_desc01");
        ignoreList.add("react_train_c_better_desc02");
        ignoreList.add("react_care_critical_desc02");
        ignoreList.add("react_care_critical_desc01");
        ignoreList.add("react_play_critical_desc01");
        ignoreList.add("react_praise_a_good_desc02");
        ignoreList.add("react_care_c_better_desc01");
        ignoreList.add("react_praise_a_good_desc01");
        ignoreList.add("react_praise_d_good_desc02");
        ignoreList.add("react_praise_d_good_desc01");
        ignoreList.add("react_praise_b_good_desc01");
        ignoreList.add("react_praise_b_good_desc02");
        ignoreList.add("react_praise_c_good_desc02");
        ignoreList.add("react_praise_c_good_desc01");
        ignoreList.add("react_play_c_better_desc02");
        ignoreList.add("react_care_c_better_desc02");
        ignoreList.add("react_play_c_better_desc01");
        ignoreList.add("react_train_a_good_desc01");
        ignoreList.add("react_play_a_better_desc01");
        ignoreList.add("react_play_a_better_desc02");
        ignoreList.add("react_train_d_better_desc01");
        ignoreList.add("react_play_b_better_desc02");
        ignoreList.add("react_play_b_better_desc01");
        ignoreList.add("react_train_d_better_desc02");
        ignoreList.add("react_care_d_better_desc02");
        ignoreList.add("react_care_d_better_desc01");
        handler.setIgnoreList(ignoreList);
        ignoreList.add("bound_radius");
        consolidateList.add("ui_colors");
        handler.setConsolidateList(consolidateList);
        handler.setIgnoreList(ignoreList);
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
        consolidateList.add("bonus_attrs");
        handler.setConsolidateList(consolidateList);
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



         */
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
