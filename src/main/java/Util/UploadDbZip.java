package Util;

import FTP.FTPFunctions;

import static Extra.Colors.ANSI_BLUE;
import static Extra.Colors.ANSI_RESET;

/**
 * @author Grzegorz Nowakowski
 */
public class UploadDbZip {

    public static void execute(String fileName) throws Exception {
        FTPFunctions ftpobj = new FTPFunctions();

        String localFile = "P:\\wamp64\\bin\\mysql\\mysql8.0.21\\bin\\" + fileName + ".zip";
        String zipName = fileName + ".zip";
        String hostDir = "/public_html/java/";

        System.out.println(ANSI_BLUE + ">> Uploading zip to server..." + ANSI_RESET);


        ftpobj.uploadFTPFile(localFile, zipName, hostDir);
    }
}
