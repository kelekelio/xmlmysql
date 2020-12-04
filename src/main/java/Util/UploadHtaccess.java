package Util;

import FTP.FTPFunctions;

import static Extra.Colors.ANSI_BLUE;
import static Extra.Colors.ANSI_RESET;

/**
 * @author Grzegorz Nowakowski
 */
public class UploadHtaccess {

    public static void execute(String type) throws Exception {

        FTPFunctions ftpobj = new FTPFunctions();

        ftpobj.uploadFTPFile("P:\\Coding\\AionPB\\htaccess\\" + type + "\\.htaccess", ".htaccess", "/public_html/java/");
        System.out.println(ANSI_BLUE + ">> " + type + " htaccess uploaded." + ANSI_RESET);

    }

}
