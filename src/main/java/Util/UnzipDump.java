package Util;

import SSH.Exec;

import static Extra.Colors.ANSI_BLUE;
import static Extra.Colors.ANSI_RESET;

/**
 * @author Grzegorz Nowakowski
 */
public class UnzipDump {

    public static void execute(String fileName) {
        System.out.println(ANSI_BLUE + ">> Unzipping DB dump..." + ANSI_RESET);
        Exec.SshCommand("unzip -o public_html/java/" + fileName + ".zip -d public_html/java/");
    }
}
