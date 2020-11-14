package DBUpdate;

import CMD.Cmd;
import DB.DB;
import DLL.DLL;
import FTP.FTPFunctions;
import SSH.SshConnection;
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
public class EuDbUpdate {

    public static void EuDbUpdateList () throws Exception {
        String version = DLL.DllVersionCheck("eu");

        DB.setiDbName("aion_eu");
        DB.newInstance().getConn().createStatement();
        SshConnection sshConnection = new SshConnection();

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
        saxParser.parse(new File("D:\\PB\\data_eu\\func_pet\\familiars.xml"), handler);

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
        System.out.println("Updating tables...");
        DB.loadTableCreate("updateTables");

        // 7. dump the db (CMD)
        System.out.println("Creating DB dump...");
        Cmd.Backupdbtosql("aion_eu_" + version, "aion_eu");

        // 8. zip the dump (CMD)
        System.out.println("Zipping DB dump...");
        Cmd.cmdExec("aion_eu_" + version);

        // 9. upload zip to ftp (FTP)
        ftpobj.uploadFTPFile("D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\aion_eu_" + version + ".zip", "aion_eu_" + version + ".zip", "/public_html/java/");

        // 10. unzip dump on server (SSH)
        System.out.println("Unzipping DB dump...");
        sshConnection.execute("unzip public_html/java/aion_eu_" + version + ".zip -d public_html/java/");

        // 11. execute source command (DB)
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Restoring DB on the server...");
        sshConnection.execute("mysql --host="+DB_HOST+" --port="+DB_PORT+" -u "+DB_USER+" -p"+DB_PASS+" kele01_java_eu < public_html/java/aion_eu_" + version + ".sql ");

        // 15. remove db files .sql and .zip (FTP)
        System.out.println("Removing .zip and .sql files...");
        ftpobj.deleteFTPFile("/public_html/java/aion_eu_" + version + ".zip");
        ftpobj.deleteFTPFile("/public_html/java/aion_eu_" + version + ".sql");
    }
}
