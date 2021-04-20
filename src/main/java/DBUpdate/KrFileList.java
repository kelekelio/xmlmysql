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

        DB.truncate("client_combine_recipe_expansion");
        handler.setTruncate(true);
        handler.setTableName("client_combine_recipes");
        handler.setInitialNode("client_combine_recipe");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_combine_recipe.xml"), handler);

        handler.setInitialNode("client_setitem");
        handler.setTableName("client_setitems");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_setitem.xml"), handler);

        DB.truncate("client_assemble_parts");
        handler.setTruncate(true);
        handler.setTableName("client_assembly_items");
        handler.setInitialNode("client_assembly_item");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_assembly_items.xml"), handler);

        //TODO: NPC
        //handler.setTruncate(true);
        handler.setInitialNode("npc_client");
        handler.setTableName("npc_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_monster.xml"), handler);

        //handler.setTruncate(true);
        handler.setInitialNode("npc_client");
        handler.setTableName("npc_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_npc.xml"), handler);

        //handler.setTruncate(true);
        handler.setInitialNode("npc_client");
        handler.setTableName("npc_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_abyss_monster.xml"), handler);

        //handler.setTruncate(true);
        handler.setInitialNode("npc_client");
        handler.setTableName("npc_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_std_monster.xml"), handler);

        //handler.setTruncate(true);
        handler.setInitialNode("npc_client");
        handler.setTableName("npc_clients");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npcs_std_abyss_monster.xml"), handler);

        //handler.setTruncate(false);
        handler.setInitialNode("client_npc_goodslist");
        handler.setTableName("client_npc_goodslists");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npc_goodslist.xml"), handler);

        //handler.setTruncate(false);
        handler.setInitialNode("client_npc_trade_in_list");
        handler.setTableName("client_npc_trade_in_lists");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\npcs\\client_npc_trade_in_list.xml"), handler);


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

        //TODO: Toypet
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




        //TODO: 8.0 Lord's Relic
        handler.setTruncate(true);
        handler.setTableName("client_sacred_stone_levels");
        handler.setInitialNode("level");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\SacredStone\\client_sacred_stone_level.xml"), handler);


    }
}
