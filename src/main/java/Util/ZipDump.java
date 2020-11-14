package Util;

import CMD.Cmd;

import static Extra.Colors.ANSI_BLUE;
import static Extra.Colors.ANSI_RESET;

/**
 * @author Grzegorz Nowakowski
 */
public class ZipDump {

    public static void ExecuteDumpZip (String fileName) throws Exception {
        System.out.println(ANSI_BLUE + ">> Zipping DB dump..." + ANSI_RESET);
        Cmd.cmdExec(fileName);
    }
}
