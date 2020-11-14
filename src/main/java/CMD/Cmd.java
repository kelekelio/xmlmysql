package CMD;

import javax.swing.*;
import java.io.*;
import java.net.URISyntaxException;
import java.security.CodeSource;

public class Cmd {


    public static void cmdExec(String fileName) throws Exception {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "\"C:\\Program Files\\7-Zip\\7z.exe\" a \"D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\" + fileName + ".zip\" \"D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\" + fileName + ".sql\" ");
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

    //todo: combine cmdExec & Backupdbtosql into one method

    public static void Backupdbtosql(String fileName, String db) {
        try {

            String savePath = "D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\" + fileName + ".sql";

            String executeCmd = "D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\mysqldump -u root --password= " + db + " -r " + savePath;

            System.out.println(executeCmd);

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Failure");
            }

        } catch (IOException | InterruptedException ex) {
            System.out.println("Error at Backuprestore" + ex.getMessage());
        }
    }
}