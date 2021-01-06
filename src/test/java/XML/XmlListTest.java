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
    void updateKoreanItemList () throws SAXException, IOException, ParserConfigurationException {


        String folderName = "data";
        DB.setiDbName("aion");
        DB.newInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();

        ArrayList<String> ignoreList = new ArrayList<>();
        ArrayList<String> consolidateList = new ArrayList<>();



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
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items_etc_1.xml"), handler);

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
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items_etc_2.xml"), handler);

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
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items_armor_1.xml"), handler);

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
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_items_armor_2.xml"), handler);

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

        ArrayList<String> ignoreList = new ArrayList<>();
        ArrayList<String> consolidateList = new ArrayList<>();



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

        ArrayList<String> ignoreList = new ArrayList<>();
        ArrayList<String> consolidateList = new ArrayList<>();

        consolidateList.add("goods_list");
        handler.setConsolidateList(consolidateList);
        //handler.setTruncate(false);
        handler.setInitialNode("client_npc_trade_in_list");
        handler.setTableName("client_npc_trade_in_lists");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npc_trade_in_list.xml"), handler);

    }


    @Test
    void updateAllLanguages () throws ParserConfigurationException, SAXException, IOException {

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

}