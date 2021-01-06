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



        //TODO: Items
        ignoreList.add("proc_fx");
        ignoreList.add("use_fx");
        ignoreList.add("use_fx_bone");
        ignoreList.add("blade_fx");
        ignoreList.add("item_fx");
        ignoreList.add("combat_item_fx");
        ignoreList.add("mesh_change");
        ignoreList.add("trail_tex");
        ignoreList.add("attack_gap");
        ignoreList.add("ui_sound_type");
        ignoreList.add("proc_enchant_effect_occur_left_prob");
        ignoreList.add("material");
        ignoreList.add("equip_bone");
        ignoreList.add("combat_equip_bone");
        ignoreList.add("price_per_use");
        ignoreList.add("bm_restrict_category");
        ignoreList.add("tag");
        ignoreList.add("ammo_fx");
        ignoreList.add("ammo_bone");
        ignoreList.add("ammo_speed");
        ignoreList.add("use_emblem");
        ignoreList.add("tool_type");
        ignoreList.add("motion_name");
        ignoreList.add("category");
        ignoreList.add("mgrouptag");
        ignoreList.add("area_to_use");
        ignoreList.add("ownership_world");
        ignoreList.add("unit_sell_count");
        ignoreList.add("activate_target_race");
        ignoreList.add("return_worldid");
        ignoreList.add("return_alias");
        ignoreList.add("sub_enchant_material_many");
        ignoreList.add("package_permitted");
        ignoreList.add("sub_enchant_material_effect_type");
        ignoreList.add("sub_enchant_material_effect");
        ignoreList.add("inven_warehouse_max_extendlevel");
        ignoreList.add("difficulty");
        ignoreList.add("scale");
        ignoreList.add("equip_type");
        ignoreList.add("f2p_pack_name");
        ignoreList.add("f2p_pack_available");
        ignoreList.add("bonus_apply");
        ignoreList.add("stigma_type");
        ignoreList.add("activation_mode");
        ignoreList.add("activate_target");
        ignoreList.add("attack_fx");
        ignoreList.add("hide_tooltip_marker");
        ignoreList.add("disuse_item_master_rate");
        ignoreList.add("looting_fx_name");
        ignoreList.add("cleanser_category");
        ignoreList.add("wing_fx");
        ignoreList.add("wing_sound");
        ignoreList.add("pennant_mesh_master");
        ignoreList.add("pennant_offset_x");
        ignoreList.add("pennant_offset_y");
        ignoreList.add("pennant_offset_z");
        ignoreList.add("pennant_scale");
        ignoreList.add("char_bm_name");
        ignoreList.add("char_bm_available_duration");
        ignoreList.add("char_bm_unique");
        ignoreList.add("megaphone_rgb");
        ignoreList.add("bm_icon");
        ignoreList.add("nboost_value");
        ignoreList.add("default_prohibit");
        ignoreList.add("ride_usable");
        ignoreList.add("use_notice");
        ignoreList.add("pennant_expire_off");
        ignoreList.add("pennant_target");
        ignoreList.add("pennant_expire_die");
        ignoreList.add("pennant_mesh_sub");
        ignoreList.add("pennant_icon");
        ignoreList.add("pennant_use_attribute");
        ignoreList.add("auto_use_on_mail_get_item");
        ignoreList.add("housing_change_size");
        ignoreList.add("recovery_instance_count");
        ignoreList.add("enchant_cpstone");
        handler.setIgnoreList(ignoreList);
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
        ignoreList.add("mobile_event");
        ignoreList.add("flag_type");
        ignoreList.add("wing_always");
        ignoreList.add("wing_mesh");
        ignoreList.add("ammo2_fx");
        ignoreList.add("ammo_hit2_fx");
        ignoreList.add("ammo3_fx");
        ignoreList.add("ammo_hit3_fx");
        ignoreList.add("left_finger");
        ignoreList.add("omit_system_msg");
        ignoreList.add("spawn_fx");
        ignoreList.add("right_finger");
        ignoreList.add("despawn_nofade");
        ignoreList.add("weapon_hit2_fx");
        ignoreList.add("no_autotarget");
        ignoreList.add("weapon_hit3_fx");
        ignoreList.add("move_speed_normal_run");
        ignoreList.add("ammo_fx");
        ignoreList.add("art_org_move_speed_normal_walk");
        ignoreList.add("stare_angle");
        ignoreList.add("spine_angle");
        ignoreList.add("out_time");
        ignoreList.add("side");
        ignoreList.add("pushed_range");
        ignoreList.add("in_time");
        ignoreList.add("material");
        ignoreList.add("move_speed_combat_run");
        ignoreList.add("sensory_range");
        ignoreList.add("neck_angle");
        ignoreList.add("art_org_speed_combat_run");
        ignoreList.add("front");
        ignoreList.add("ammo_bone");
        ignoreList.add("dmg_decal_texture");
        ignoreList.add("weapon_hit_fx");
        ignoreList.add("foot_mat");
        ignoreList.add("hide_shadow");
        ignoreList.add("ammo_hit_fx");
        ignoreList.add("float_corpse");
        ignoreList.add("dmg_texture");
        ignoreList.add("glove");
        ignoreList.add("main");
        ignoreList.add("leg");
        ignoreList.add("shoulder");
        ignoreList.add("face_type");
        ignoreList.add("sub");
        ignoreList.add("head");
        ignoreList.add("foot");
        ignoreList.add("torso");
        ignoreList.add("hair_type");
        ignoreList.add("appearance");
        ignoreList.add("visible_equipments");
        ignoreList.add("talk_animation");
        ignoreList.add("ammo_speed");
        ignoreList.add("altitude");
        ignoreList.add("upper");
        ignoreList.add("move_speed_normal_walk");
        ignoreList.add("scale");
        ignoreList.add("erect");
        ignoreList.add("pet_ai_name");
        ignoreList.add("ai_name");
        ignoreList.add("show_dmg_decal");
        ignoreList.add("stare_distance");
        ignoreList.add("weapon_scale");
        ignoreList.add("cursor_type");
        ignoreList.add("talking_distance");
        ignoreList.add("quest_ai_name");
        ignoreList.add("appearance_custom");
        ignoreList.add("idle_animation");
        ignoreList.add("ment");
        ignoreList.add("walk_animation");
        ignoreList.add("airlines_name");
        ignoreList.add("title_offset");
        ignoreList.add("face_color");
        ignoreList.add("hair_color");
        ignoreList.add("fxc_type");
        ignoreList.add("user_animation");
        ignoreList.add("talk_delay_time");
        ignoreList.add("mgrouptag");
        ignoreList.add("static");
        ignoreList.add("sanctuary_animation");
        ignoreList.add("jobfaction_name");
        ignoreList.add("faction_amount");
        ignoreList.add("back");
        ignoreList.add("right_ear");
        ignoreList.add("neck");
        ignoreList.add("left_ear");
        ignoreList.add("town_residence");
        ignoreList.add("func_town_challenge");
        ignoreList.add("war_flag_group_id2");
        ignoreList.add("inherite_tribe");
        ignoreList.add("func_housing_script");
        ignoreList.add("func_housing_config");
        ignoreList.add("func_personal_auction");
        ignoreList.add("func_housing_change_building");
        ignoreList.add("func_housing_pay_rent");
        ignoreList.add("func_housing_kick");
        ignoreList.add("save_trade_count");
        ignoreList.add("war_flag_group_id");
        handler.setIgnoreList(ignoreList);
        consolidateList.add("extra_currency_trade_info");
        consolidateList.add("trade_info");
        consolidateList.add("trade_in_trade_info");
        consolidateList.add("abyss_trade_info");
        consolidateList.add("coupon_trade_info");
        consolidateList.add("abyss_trade_buy_info");
        consolidateList.add("event_tool_trade_info");
        consolidateList.add("abyss_qina_trade_info");
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
