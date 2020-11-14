package DBUpdate;

import CMD.Cmd;
import DB.DB;
import DLL.DLL;
import FTP.FTPFunctions;
import SSH.Exec;
import SSH.SshConnection;
import Util.*;
import XML.GeneralHandler;
import XML.VersionHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import static Extra.Colors.ANSI_RED;
import static Extra.Colors.ANSI_RESET;
import static Extra.Config.*;

/**
 * @author Grzegorz Nowakowski
 */
public class ClassicDbUpdate {

    public static void ClassicDbUpdateList () throws Exception {
        String version = DLL.DllVersionCheck("classic");

        DB.setiDbName("aion_c");
        DB.newInstance().getConn().createStatement();

        FTPFunctions ftpobj = new FTPFunctions();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();

        ArrayList<String> ignoreList = new ArrayList<>();

        ignoreList.add("bound_radius");
        handler.setIgnoreList(ignoreList);
        handler.setTruncate(false);
        handler.setInitialNode("client_familiar");
        handler.setTableName("client_familiars");
        try {
            saxParser.parse(new File("D:\\PB\\data\\func_pet\\familiars.xml"), handler);
        } catch(Exception ignored){}
        ignoreList.clear();


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


        // 6. execute update commands (DB)
        TableUpdate.ExecuteTableUpdate();

        // 7. dump the db (CMD)
        DumpDb.ExecuteDbDump("aion_classic_" + version, "aion_c");

        // 8. zip the dump (CMD)
        ZipDump.ExecuteDumpZip("aion_classic_" + version);

        // 9. upload zip to ftp (FTP)
        UploadDbZip.executeDbZipUpload("aion_classic_" + version);

        // 10. unzip dump on server (SSH)
        UnzipDump.ExecuteDumpUnzip("aion_classic_" + version);

        // 11. execute source command (DB)
        RestoreDbOnServer.ExecuteDbRestorationOnServer("kele01_java_classic", "aion_classic_" + version);

        // 15. remove db files .sql and .zip (FTP)
        RemoveZipSql.ExecuteSqlZipRemoval("aion_classic_" + version);


        DB.execute("UPDATE `aion`.`appdata` SET `data` = '" + version + "' WHERE (`name` = 'classicversion');");

    }

}
