package Util;

import FTP.FTPFunctions;

import static Extra.Colors.ANSI_BLUE;
import static Extra.Colors.ANSI_RESET;

/**
 * @author Grzegorz Nowakowski
 */
public class RemoveZipSql {

    public static void ExecuteSqlZipRemoval (String fileName) throws Exception {
        FTPFunctions ftpobj = new FTPFunctions();

        System.out.println(ANSI_BLUE + ">> Removing .zip and .sql files..." + ANSI_RESET);
        ftpobj.deleteFTPFile("/public_html/java/" + fileName + ".zip");
        ftpobj.deleteFTPFile("/public_html/java/" + fileName + ".sql");
    }
}
