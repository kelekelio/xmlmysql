package DBUpdate;

import DB.DB;
import DLL.DLL;
import Util.*;

/**
 * @author Grzegorz Nowakowski
 */
public class KrDbUpdate {

    public static void KrDbUpdateList () throws Exception {
        String version = DLL.DllVersionCheck("kr");
        String db = "aion";

        // 2. File list
        KrFileList.selectedFiles();

        // 6. execute update commands (DB)
        TableUpdate.execute();

        // 7. dump the db (CMD)
        DumpDb.execute("aion_" + version, "aion");

        // 8. zip the dump (CMD)
        ZipDump.execute("aion_" + version);

        // 9. upload zip to ftp (FTP)
        UploadDbZip.execute("aion_" + version);

        // 10. unzip dump on server (SSH)
        UnzipDump.execute("aion_" + version);

        // 11. execute source command (DB)
        RestoreDbOnServer.execute("kele01_java", "aion_" + version);

        // 15. remove db files .sql and .zip (FTP)
        RemoveZipSql.execute("aion_" + version);

        DB.execute("UPDATE `aion`.`appdata` SET `data` = '" + version + "' WHERE (`name` = 'krversion');");

    }
}
