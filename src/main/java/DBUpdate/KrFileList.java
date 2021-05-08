package DBUpdate;

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
public class KrFileList {

    public static void selectedFiles(SAXParser saxParser, GeneralHandler handler, VersionHandler versionHandler, LanguageHandler languageHandler) throws IOException, SAXException, ParserConfigurationException {

        String folderName = "data";


        //TODO: Items
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

        DB.truncate("client_combine_recipes_combine_recipe_expansion");
        handler.setTruncate(true);
        handler.setTableName("client_combine_recipes");
        handler.setInitialNode("client_combine_recipe");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_combine_recipe.xml"), handler);


        handler.setTableName("client_setitems");
        handler.setInitialNode("client_setitem");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_setitem.xml"), handler);

        DB.truncate("client_assembly_items_assemble_parts");
        handler.setTruncate(true);
        handler.setTableName("client_assembly_items");
        handler.setInitialNode("client_assembly_item");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_assembly_items.xml"), handler);

        DB.truncate("client_disassemblyitemsetlists_disassembly_create_item_list");
        handler.setTruncate(true);
        handler.setTableName("client_disassemblyitemsetlists");
        handler.setInitialNode("client_disassemblyitemsetlist");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_disassembly_item_SetList.xml"), handler);

        DB.truncate("client_disassemblyitemsets_disassemble_set_list");
        handler.setTruncate(true);
        handler.setTableName("client_disassemblyitemsets");
        handler.setInitialNode("client_disassemblyitemset");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_disassembly_item.xml"), handler);

        DB.truncate("item_random_options_random_attr_group_list");
        handler.setTruncate(true);
        handler.setTableName("item_random_options");
        handler.setInitialNode("item_random_option");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_item_random_option.xml"), handler);

        DB.truncate("real_item_random_options_random_option_list");
        handler.setTruncate(true);
        handler.setTableName("real_item_random_options");
        handler.setInitialNode("real_item_random_option");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_real_item_random_option.xml"), handler);

        DB.truncate("item_enchants_enchant_attr_list");
        DB.truncate("item_enchants_limitless_attr_list");
        handler.setTruncate(true);
        handler.setTableName("item_enchants");
        handler.setInitialNode("item_enchant");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_item_enchanttable.xml"), handler);

        DB.truncate("item_authorizes_enchant_attr_list");
        DB.truncate("item_authorizes_limitless_attr_list");
        handler.setTruncate(true);
        handler.setTableName("item_authorizes");
        handler.setInitialNode("item_authorize");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_item_authorizetable.xml"), handler);

        DB.truncate("client_item_upgrades_upgrade_list");
        handler.setTruncate(true);
        handler.setTableName("client_item_upgrades");
        handler.setInitialNode("client_item_upgrade");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_item_upgrade.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_reinvent_materials");
        handler.setInitialNode("client_reinvent_material");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_reinvent_material.xml"), handler);

        DB.truncate("client_item_skill_enhances_enchant_prob_list");
        DB.truncate("client_item_skill_enhances_enchant_skill_list");
        handler.setTruncate(true);
        handler.setTableName("client_item_skill_enhances");
        handler.setInitialNode("client_item_skill_enhance");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_item_skill_enhance.xml"), handler);

        DB.truncate("grind_item_compounds_material_list");
        DB.truncate("grind_item_compounds_result_list");
        handler.setTruncate(true);
        handler.setTableName("grind_item_compounds");
        handler.setInitialNode("grind_item_compound");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\grind_item_compound.xml"), handler);

        DB.truncate("enchant_datadrivens_enchant_level_list");
        handler.setTruncate(true);
        handler.setTableName("enchant_datadrivens");
        handler.setInitialNode("enchant_datadriven");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\enchant_datadriven.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_itemcustomsets");
        handler.setInitialNode("client_itemcustomset");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_item_custom_set.xml"), handler);

        DB.truncate("client_login_events_reward_item_list");
        handler.setTruncate(true);
        handler.setTableName("client_login_events");
        handler.setInitialNode("client_login_event");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_login_event.xml"), handler);

        DB.truncate("client_reinvent_packages_candidate_list");
        DB.truncate("client_reinvent_packages_ui_reward_list");
        handler.setTruncate(true);
        handler.setTableName("client_reinvent_packages");
        handler.setInitialNode("client_reinvent_package");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_reinvent_package.xml"), handler);




        //TODO: NPC
        //handler.setTruncate(true);
        handler.setTableName("npc_clients");
        handler.setInitialNode("npc_client");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_monster.xml"), handler);

        //handler.setTruncate(true);
        handler.setTableName("npc_clients");
        handler.setInitialNode("npc_client");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_npc.xml"), handler);

        //handler.setTruncate(true);
        handler.setTableName("npc_clients");
        handler.setInitialNode("npc_client");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_abyss_monster.xml"), handler);

        //handler.setTruncate(true);
        handler.setTableName("npc_clients");
        handler.setInitialNode("npc_client");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_std_monster.xml"), handler);

        //handler.setTruncate(true);
        handler.setTableName("npc_clients");
        handler.setInitialNode("npc_client");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_test_monster.xml"), handler);

        //handler.setTruncate(true);
        handler.setTableName("npc_clients");
        handler.setInitialNode("npc_client");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_std_abyss_monster.xml"), handler);

        DB.truncate("client_npc_purchase_lists_goods_list");
        //handler.setTruncate(false);
        handler.setTableName("client_npc_purchase_lists");
        handler.setInitialNode("client_npc_purchase_list");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npc_purchase_list.xml"), handler);


        DB.truncate("client_npc_goodslists_goods_list");
        //handler.setTruncate(false);
        handler.setTableName("client_npc_goodslists");
        handler.setInitialNode("client_npc_goodslist");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npc_goodslist.xml"), handler);

        DB.truncate("client_npc_trade_in_list_goods_list");
        //handler.setTruncate(false);
        handler.setTableName("client_npc_trade_in_lists");
        handler.setInitialNode("client_npc_trade_in_list");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npc_trade_in_list.xml"), handler);


        //TODO: PC
        DB.truncate("client_titles_bonus_attrs");
        //handler.setTruncate(false);
        handler.setTableName("client_titles");
        handler.setInitialNode("client_title");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\pc\\client_titles.xml"), handler);


        //TODO: Achievements
        handler.setTruncate(true);
        handler.setTableName("client_achievements");
        handler.setInitialNode("client_achievement");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\pc\\client_achievement.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_achievement_actions");
        handler.setInitialNode("client_achievement_action");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\pc\\client_achievement_action.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_achievement_events");
        handler.setInitialNode("client_achievement_event");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\pc\\client_achievement_event.xml"), handler);


        //TODO: func_pet
        handler.setTruncate(true);
        handler.setTableName("client_familiars");
        handler.setInitialNode("client_familiar");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\familiars.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_toypets");
        handler.setInitialNode("client_toypet");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\toypets.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_toypet_warehouses");
        handler.setInitialNode("client_toypet_warehouse");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\toypet_warehouse.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_toypet_merchants");
        handler.setInitialNode("client_toypet_merchant");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\toypet_merchant.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_toypet_lootings");
        handler.setInitialNode("client_toypet_looting");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\toypet_looting.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_toypet_items");
        handler.setInitialNode("client_toypet_item");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\toypet_item.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_toypet_feeds");
        handler.setInitialNode("client_toypet_feed");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\toypet_feed.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_toypet_dopings");
        handler.setInitialNode("client_toypet_doping");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\toypet_doping.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_toypet_buffs");
        handler.setInitialNode("client_toypet_buff");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\func_pet\\toypet_buff.xml"), handler);


        //TODO: Gather
        handler.setTruncate(true);
        handler.setTableName("gather_srcs");
        handler.setInitialNode("gather_src");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Gather\\gather_src.xml"), handler);


        //TODO: Housing
        handler.setTruncate(true);
        handler.setTableName("client_housing_objects");
        handler.setInitialNode("client_housing_object");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Housing\\client_housing_object.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_housing_custom_parts");
        handler.setInitialNode("client_housing_custom_part");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Housing\\client_housing_custom_part.xml"), handler);

        //TODO: Luna
        handler.setTruncate(true);
        handler.setTableName("client_luna_consume_rewards");
        handler.setInitialNode("client_luna_consume_reward");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Luna\\client_luna_consume_reward.xml"), handler);

        handler.setTruncate(true);
        handler.setTableName("client_luna_recipes");
        handler.setInitialNode("client_luna_recipe");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\Luna\\client_luna_recipe.xml"), handler);






        //TODO: 8.0 Lord's Relic
        handler.setTruncate(true);
        handler.setTableName("client_sacred_stone_levels");
        handler.setInitialNode("level");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\SacredStone\\client_sacred_stone_level.xml"), handler);


    }
}
