package Util;

import CMD.Cmd;

import static Extra.Colors.ANSI_BLUE;
import static Extra.Colors.ANSI_RESET;

/**
 * @author Grzegorz Nowakowski
 */
public class DumpDb {

    public static void execute(String fileName, String dbName) {
        System.out.println(ANSI_BLUE + ">> Creating DB dump..." + ANSI_RESET);
        Cmd.Backupdbtosql(fileName, dbName);
    }
}
