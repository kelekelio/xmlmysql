import FTP.FTPFunctions;
import XML.GeneralHandler;
import XML.VersionHandler;
import com.jcraft.jsch.JSchException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {



    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, JSchException {

        //TODO:
        // 1. compare local versions with one saved in db
        // 2. send discord notif
        // 3. upload down htaccess
        // 4. rename powerbook folder to pb
        // 5. start db update
        // 6. execute update commands
        // 7. dump the db
        // 8. zip the dump
        // 9. upload zip to ftp
        // 10. unzip dump on server
        // 11. execute source command
        // 12. execute cache wipe
        // 13. rename the folder back to powerbook
        // 14. upload live htaccess
        // 15. send discord notif
        // 16. remove db files .sql and .zip
        // 17. enclose everything in switch to force update or quit on no-new-version


        long startTime = System.nanoTime();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();

        ArrayList<String> ignoreList = new ArrayList<>();


        /*
        try {
            FTPFunctions ftpobj = new FTPFunctions("host", 21, "user", "pass");
            ftpobj.uploadFTPFile("P:\\2Q18_PT_ENG.pdf", "2Q18_PT_ENG.pdf", "/public_html/java/");
            //ftpobj.uploadFTPFile("P:\\Coding\\AionPB\\htaccess\\down\\.htaccess", ".htaccess", "/public_html/java/");
            //ftpobj.uploadFTPFile("P:\\Coding\\AionPB\\htaccess\\live\\.htaccess", ".htaccess", "/public_html/java/");
            //ftpobj.uploadFTPFile("D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\26158902_db_1409.zip", "26158902_db_1409.zip", "/public_html/java/");
            ftpobj.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

         */


        /*
        System.out.println("ssh wipe");
        UserAuthPubKey ssh = new UserAuthPubKey();
        ssh.executeSSH(ssh.getSession(), "find public_html/java/testdelete/ -type f -name \"*.html\" -delete");
        System.out.println("ssh wipe done");
         */



/*
        DiscordWebhook webhook = new DiscordWebhook("https://discordapp.com/api/webhooks/710484134773915648/VYvTlgWV-0hOIm04wbzpQg6o5vXmvYzegTvX0Ap1eqQjcRwuPBtHQ3nFDuQaE0dwqF_R");
        webhook.setUsername("Aion is Dead");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
            .setTitle("Version Update")
            .setDescription("New game version detected!")
            .setColor(Color.RED)
            .addField("KR", DLL.DllVersionCheck("kr"), true)
            .addField("EU", DLL.DllVersionCheck("eu"), true)
            .setThumbnail("https://kryptongta.com/images/kryptonlogo.png")
            .setFooter("Update initiated. Estimated downtime: 5min", "")
            .setUrl("https://aionpowerbook.com/powerbook/Version"));
        webhook.execute(); //Handle exception
 */



        //TODO: set the list of files in a file????
        // <file_url></file_url>
        // <handler></handler>
        // <IgnoreList></IgnoreList>
        // <InitialNode></InitialNode>
        // <TableName></TableName>
        // <Truncate></Truncate>
        // <consolidate></consolidate>

/*
        ignoreList.add("bound_radius");
        handler.setIgnoreList(ignoreList);
        handler.setTruncate(false);
        handler.setInitialNode("client_familiars");
        handler.setTableName("client_familiar");
        saxParser.parse(new File("D:\\PB\\data\\func_pet\\familiars.xml"), handler);



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







        //files too large to be pushed to github.

        versionHandler.setRegion("kr");
        versionHandler.setInitialNode("client_items");
        versionHandler.setTableName("client_item");
        saxParser.parse(new File("D:/PB/data/items/client_items_etc_1.xml"), versionHandler);
        saxParser.parse(new File("D:/PB/data/items/client_items_etc_2.xml"), versionHandler);
        versionHandler.setRegion("eu");
        saxParser.parse(new File("D:/PB/data_eu/items/client_items_etc_2.xml"), versionHandler);


         */

        /*
        Cmd.Backupdbtosql();


        try {
            Cmd.cmdExec();
        } catch (Exception e) {
            e.printStackTrace();
        }

         */

        long elapsedTime = (System.nanoTime() - startTime)/1000000;

        System.out.println(
                new SimpleDateFormat("mm:ss").format(new Date(elapsedTime))
        );


    }
}
