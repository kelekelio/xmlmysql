package Util;

import SSH.Exec;

import static Extra.Colors.ANSI_BLUE;
import static Extra.Colors.ANSI_RESET;

/**
 * @author Grzegorz Nowakowski
 */
public class CacheWipe {

    public static void executeCacheWipe() {
        Exec.SshCommand("find public_html/java/testdelete/ -type f -name \"*.html\" -delete");
        System.out.println(ANSI_BLUE + ">> Cache wiped" + ANSI_RESET);
    }
}
