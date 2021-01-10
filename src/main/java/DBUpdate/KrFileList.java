package DBUpdate;

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

    public static void selectedFiles() throws IOException, SAXException, ParserConfigurationException {

        String folderName = "data";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();



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

        handler.setInitialNode("client_combine_recipe");
        handler.setTableName("client_combine_recipes");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_combine_recipe.xml"), handler);

        handler.setInitialNode("client_setitem");
        handler.setTableName("client_setitems");
        saxParser.parse(new File("D:\\PB\\" + folderName + "\\items\\client_setitem.xml"), handler);

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


    }
}
