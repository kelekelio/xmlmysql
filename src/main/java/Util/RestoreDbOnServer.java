package Util;

import SSH.Exec;

import java.util.concurrent.TimeUnit;

import static Extra.Colors.ANSI_BLUE;
import static Extra.Colors.ANSI_RESET;
import static Extra.Config.*;
import static Extra.Config.DB_PASS;

/**
 * @author Grzegorz Nowakowski
 */
public class RestoreDbOnServer {

    public static void ExecuteDbRestorationOnServer(String dbName, String fileName) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println(ANSI_BLUE + ">> Restoring DB on the server..." + ANSI_RESET);
        Exec.SshCommand("mysql --host=" + DB_HOST + " --port=" + DB_PORT + " -u " + DB_USER + " -p" + DB_PASS + " " + dbName + " < public_html/java/" + fileName + ".sql ");

    }
}
