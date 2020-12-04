package Util;

import DB.DB;

import java.io.IOException;

import static Extra.Colors.ANSI_BLUE;
import static Extra.Colors.ANSI_RESET;

/**
 * @author Grzegorz Nowakowski
 */
public class TableUpdate {

    public static void execute() throws IOException {
        System.out.println(ANSI_BLUE + ">> Updating tables..." + ANSI_RESET);
        DB.loadTableCreate("updateTables");
    }
}
