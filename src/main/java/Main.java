
import SSH.SshConnection;
import Util.Controller;
import Util.StartApp;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        //TODO:
        //      1. compare local versions with the ones saved in db
        //      2. send discord notif (Disc)
        //      3. upload down htaccess (FTP)
        //      4. rename powerbook folder to pb (SSH)
        //      5. start db update (DB)
        //      6. execute update commands (DB)
        //      7. dump the db (CMD)
        //      8. zip the dump (CMD)
        //      9. upload zip to ftp (FTP)
        //      10. unzip dump on server (SSH)
        //      11. execute source command (DB)
        //      12. execute cache wipe (SSH)
        //      13. rename the folder back to powerbook (SSH)
        //      14. upload live htaccess (FTP)
        //      15. remove db files .sql and .zip (FTP)
        //      16. enclose everything in switch to force update or quit on no-new-version


        long startTime = System.nanoTime();

        //old
        //Controller.InitApp();

        //new
        StartApp.start();


        long elapsedTime = (System.nanoTime() - startTime)/1000000;

        System.out.println(
                new SimpleDateFormat("mm:ss").format(new Date(elapsedTime))
        );


    }
}
