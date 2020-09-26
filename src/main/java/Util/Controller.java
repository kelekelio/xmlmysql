package Util;

import CMD.Cmd;
import DB.DB;
import DLL.DLL;
import Discord.DiscordWebhook;
import FTP.FTPFunctions;
import SSH.UserAuthPubKey;
import XML.XmlList;

import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    private static boolean krversion;
    private static boolean euversion;
    private static String krvalue;
    private static String euvalue;


    public static void InitApp() throws Exception {
        FTPFunctions ftpobj = new FTPFunctions();
        DiscordWebhook webhook = new DiscordWebhook();
        UserAuthPubKey ssh = new UserAuthPubKey();

        // 1. compare local versions with one saved in db
        ResultSet results = DB
                .getInstance()
                .getConn()
                .createStatement()
                .executeQuery("select value from appdata where name = \"kr_version\" ");
        if (results.next()) {
            krvalue = results.getString("value");
        }
        if (krvalue.equals(DLL.DllVersionCheck("kr"))) {
            krversion = true;
        }

        ResultSet resultseu = DB
                .getInstance()
                .getConn()
                .createStatement()
                .executeQuery("select value from appdata where name = \"eu_version\" ");
        if (resultseu.next()) {
            euvalue = resultseu.getString("value");
        }
        if (euvalue.equals(DLL.DllVersionCheck("eu"))) {
            euversion = true;
        }

        if (krversion && euversion) {
            System.out.println("both versions are the same");
        }else {
            System.out.println("one of the versions does not macth");
        }


        Scanner scanner = new Scanner(System.in);
        String operation;

        System.out.println("Initiate Update? [y]es / [n]o");
        operation = scanner.next().toLowerCase();



        if (operation.equals("y")) {
            // 2. send discord notif (Disc)
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


            // 3. upload down htaccess (FTP)
            ftpobj.uploadFTPFile("P:\\Coding\\AionPB\\htaccess\\down\\.htaccess", ".htaccess", "/public_html/java/");
            System.out.println("Down htaccess uploaded.");

            // 4. rename powerbook folder to pb (SSH)
            ssh.executeSSH(ssh.getSession(), "mv public_html/java/powerbook public_html/java/pb");
            System.out.println("Folder: powerbook => pb");

            // 5. start db update (DB)
            System.out.println("Updateing the DB...");
            XmlList.XmlFileList();

            // 6. execute update commands (DB)
            System.out.println("Updating tables...");
            DB.loadTableCreate("updateTables");

            // 7. dump the db (CMD)
            System.out.println("Creating DB dump...");
            Cmd.Backupdbtosql(DLL.DllVersionCheck("kr"));

            // 8. zip the dump (CMD)
            System.out.println("Zipping DB dump...");
            Cmd.cmdExec(DLL.DllVersionCheck("kr"));

            // 9. upload zip to ftp (FTP)
            ftpobj.uploadFTPFile("D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\26158902_db_1409.zip", "26158902_db_1409.zip", "/public_html/java/");

            // 10. unzip dump on server (SSH)
            System.out.println("Unzipping DB dump...");
            ssh.executeSSH(ssh.getSession(), "unzip public_html/java/26158902_db_2708.zip -d public_html/java/");

            // 11. execute source command (DB)
            System.out.println("Restoring DB on the server...");

            // 12. execute cache wipe (SSH)
            ssh.executeSSH(ssh.getSession(), "find public_html/java/testdelete/ -type f -name \"*.html\" -delete");
            System.out.println("Cache wiped");

            // 13. rename the folder back to powerbook (SSH)
            ssh.executeSSH(ssh.getSession(), "mv public_html/java/pb public_html/java/powerbook");
            System.out.println("Folder: pb => powerbook");

            // 14. upload live htaccess (FTP)
            ftpobj.uploadFTPFile("P:\\Coding\\AionPB\\htaccess\\live\\.htaccess", ".htaccess", "/public_html/java/");
            System.out.println("Live htaccess uploaded.");

            // 15. remove db files .sql and .zip (FTP)
            System.out.println("Removing .zip and .sql files...");
            ftpobj.deleteFTPFile("/public_html/java/26158902_db_1409.zip");
            ftpobj.deleteFTPFile("/public_html/java/26158902_db_2708.sql");



            ssh.closeSSH();
            ftpobj.disconnect();
        } else if (operation.equals("n")) {
            System.out.println("Bye!");
        }






    }

}
