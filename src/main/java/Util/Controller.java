package Util;

import DB.DB;
import DBUpdate.DbUpdate;
import DLL.DLL;
import MediaWiki.MediaWiki;

import java.io.File;
import java.util.Scanner;

import static Extra.Colors.*;

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






        System.out.println("1. KR: " + krDbRecord       + " => " + krDllRecord);
        System.out.println("2. EU: " + euDbRecord       + " => " + euDllRecord);
        System.out.println("3. Cl: " + classicDbRecord  + " => " + classicDllRecord);


        Scanner scanner = new Scanner(System.in);
        int updateDB;
        int extraCommands = 999;
        boolean initiate = true;
        System.out.println("Which DB would you like to update? [1], [2], [3], [4] for all, [5] extra");
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
            case 5:

                while (extraCommands != 0) {
                    System.out.println("Following actions can be performed:");
                    System.out.println("[1] Send discord notification");
                    System.out.println("[2] upload down htaccess (FTP)");
                    System.out.println("[3] rename powerbook folder to pb (SSH)");
                    System.out.println("[4] execute cache wipe (SSH)");
                    System.out.println("[5] rename the folder back to powerbook (SSH)");
                    System.out.println("[6] upload live htaccess (FTP)");
                    System.out.println("[7] create wiki page for Live version");
                    System.out.println("[8] create wiki page for Classic version");
                    System.out.println("[9] update the version on the Main Page");
                    System.out.println("[0] to exit");
                    extraCommands = scanner.nextInt();
                    scanner.nextLine();

                    switch (extraCommands) {
                        case 1 -> DiscordNotification.sendDiscordNotification(krDllRecord, euDllRecord, classicDllRecord);
                        case 2 -> UploadHtaccess.execute("down");
                        case 3 -> RenamePbFolder.execute(0);
                        case 4 -> CacheWipe.execute();
                        case 5 -> RenamePbFolder.execute(1);
                        case 6 -> UploadHtaccess.execute("live");
                        case 7 -> MediaWiki.createArticle(krDllRecord, "aion");
                        case 8 -> MediaWiki.createArticle(classicDllRecord, "aion_classic");
                        case 9 -> MediaWiki.editMainPage(krDllRecord, classicDllRecord, krDbRecord, classicDbRecord);
                        default -> initiate = false;
                    }
                }

            default:
                break;
        }

        String operation = "";

        if (initiate) {
            System.out.println("Initiate Update? [y]es / [n]o");
            operation = scanner.next().toLowerCase();
        }



        if (operation.equals("y") && initiate) {

            // 2. send discord notif (Disc)
            DiscordNotification.sendDiscordNotification(krDllRecord, euDllRecord, classicDllRecord);

            // 3. upload down htaccess (FTP)
            UploadHtaccess.execute("down");

            // 4. rename powerbook folder to pb (SSH)
            RenamePbFolder.execute(0);



            // 5. start db update (DB)
            if (updateKR) {
                System.out.println(ANSI_BLUE + ">> Updating the Korean DB..." + ANSI_RESET);
                //KrDbUpdate.KrDbUpdateList();
                DbUpdate.execute("aion", krDllRecord);
            }

            if (updateEU) {

                System.out.println(ANSI_BLUE + ">> Updating the European DB..." + ANSI_RESET);
                //EuDbUpdate.EuDbUpdateList();
                DbUpdate.execute("aion_eu", euDllRecord);
            }

            if (updateClassic) {
                System.out.println(ANSI_BLUE + ">> Updating the Classic DB..." + ANSI_RESET);
                //ClassicDbUpdate.ClassicDbUpdateList();
                DbUpdate.execute("aion_classic", classicDllRecord);
            }


            // 12. execute cache wipe (SSH)
            CacheWipe.execute();

            // 13. rename the folder back to powerbook (SSH)
            RenamePbFolder.execute(1);

            // 14. upload live htaccess (FTP)
            UploadHtaccess.execute("live");


            System.out.println(ANSI_RED + "There have been " + DB.getAlters() + " table alterations." + ANSI_RESET);

        } else if (operation.equals("n")) {
            System.out.println("Bye!");
        }






    }

}
