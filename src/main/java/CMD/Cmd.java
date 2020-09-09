package CMD;

import javax.swing.*;
import java.io.*;
import java.net.URISyntaxException;
import java.security.CodeSource;

public class Cmd {


    public static void cmdExec() throws Exception {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "\"C:\\Program Files\\7-Zip\\7z.exe\" a \"D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\26158902_db_test.zip\" \"D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\26158902_db_test.sql\" ");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
    }

    public static void Backupdbtosql() {
        try {

            /*NOTE: Getting path to the Jar file being executed*/
            /*NOTE: YourImplementingClass-> replace with the class executing the code*/



            /*NOTE: Creating Database Constraints*/
            String dbName = "26158902_db";
            String dbUser = "root";
            String dbPass = "";

            /*NOTE: Creating Path Constraints for folder saving*/
            /*NOTE: Here the backup folder is created for saving inside it*/


            /*NOTE: Creating Path Constraints for backup saving*/
            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
            String savePath = "D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\26158902_db_test.sql";

            /*NOTE: Used to create a cmd command*/
            String executeCmd = "D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\mysqldump -u " + dbUser + " --password=" + dbPass + " " + dbName + " -r " + savePath;

            System.out.println(executeCmd);

            /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Failure");
            }

        } catch (IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
        }
    }
}