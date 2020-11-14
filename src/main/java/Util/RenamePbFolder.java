package Util;

import SSH.Exec;

import static Extra.Colors.ANSI_BLUE;
import static Extra.Colors.ANSI_RESET;

/**
 * @author Grzegorz Nowakowski
 */
public class RenamePbFolder {

    public static void executeFolderRename(int type) {
        if (type == 0) {
            Exec.SshCommand( "mv public_html/java/powerbook public_html/java/pb");
            System.out.println(ANSI_BLUE + ">> Folder: powerbook => pb" + ANSI_RESET);
        } else {
            Exec.SshCommand( "mv public_html/java/pb public_html/java/powerbook");
            System.out.println(ANSI_BLUE + ">> Folder: pb => powerbook" + ANSI_RESET);
        }


    }
}
