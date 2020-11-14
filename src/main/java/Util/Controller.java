package Util;

import CMD.Cmd;
import DB.DB;
import DBUpdate.ClassicDbUpdate;
import DBUpdate.EuDbUpdate;
import DBUpdate.KrDbUpdate;
import DLL.DLL;
import Discord.DiscordWebhook;
import FTP.FTPFunctions;
import SSH.Exec;
import SSH.SshConnection;
import XML.XmlList;

import java.awt.*;
import java.io.File;
import java.sql.ResultSet;
import java.util.Scanner;

import static Extra.Colors.*;
import static Extra.Config.*;

public class Controller {

    private static boolean updateKR = false;
    private static boolean updateEU = false;
    private static boolean updateClassic = false;


    public static void InitApp() throws Exception {




        // 0. Delete AlterTables.txt
        try {
            File f = new File("P:\\AlterTables.txt");
            if (f.delete()) {
                System.out.println(f.getName() + " deleted");
            }
            else {
                System.out.println("failed");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // 1. compare local versions with one saved in db
        String krDbRecord = DB.returnValue("appdata", "name", "krversion", "data");
        String euDbRecord = DB.returnValue("appdata", "name", "euversion", "data");
        String classicDbRecord = DB.returnValue("appdata", "name", "classicversion", "data");

        String krDllRecord = DLL.DllVersionCheck("kr");
        String euDllRecord = DLL.DllVersionCheck("eu");
        String classicDllRecord = DLL.DllVersionCheck("classic");






        System.out.println("1: " + krDbRecord       + " => " + krDllRecord);
        System.out.println("2: " + euDbRecord       + " => " + euDllRecord);
        System.out.println("3: " + classicDbRecord  + " => " + classicDllRecord);


        Scanner scanner = new Scanner(System.in);
        int updateDB;
        System.out.println("Which DB would you like to update? [1], [2], [3], [4] for all");
        updateDB = scanner.nextInt();

        switch (updateDB) {
            case 1:
                updateKR = true;
                break;
            case 2:
                updateEU = true;
                break;
            case 3:
                updateClassic = true;
                break;
            case 4:
                updateKR = true;
                updateEU = true;
                updateClassic = true;
                break;
            default:
                break;
        }

        String operation;

        System.out.println("Initiate Update? [y]es / [n]o");
        operation = scanner.next().toLowerCase();



        if (operation.equals("y")) {

            // 2. send discord notif (Disc)
            DiscordNotification.sendDiscordNotification(krDllRecord, euDllRecord, classicDllRecord);

            // 3. upload down htaccess (FTP)
            UploadHtaccess.executeHtaccessUpload("down");

            // 4. rename powerbook folder to pb (SSH)
            RenamePbFolder.executeFolderRename(0);



            // 5. start db update (DB)
            if (updateKR) {
                System.out.println(ANSI_BLUE + ">> Updating the Korean DB..." + ANSI_RESET);
                KrDbUpdate.KrDbUpdateList();
            }

            if (updateEU) {

                System.out.println(ANSI_BLUE + ">> Updating the European DB..." + ANSI_RESET);
                EuDbUpdate.EuDbUpdateList();
            }

            if (updateClassic) {
                System.out.println(ANSI_BLUE + ">> Updating the Classic DB..." + ANSI_RESET);
                ClassicDbUpdate.ClassicDbUpdateList();
            }


            // 12. execute cache wipe (SSH)
            CacheWipe.executeCacheWipe();

            // 13. rename the folder back to powerbook (SSH)
            RenamePbFolder.executeFolderRename(1);

            // 14. upload live htaccess (FTP)
            UploadHtaccess.executeHtaccessUpload("live");


            System.out.println(ANSI_RED + "There have been " + DB.getAlters() + " table alterations." + ANSI_RESET);

        } else if (operation.equals("n")) {
            System.out.println("Bye!");
        }






    }

}
