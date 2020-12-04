package DBUpdate;

import DB.DB;
import DLL.DLL;
import Util.*;

/**
 * @author Grzegorz Nowakowski
 */
public class EuDbUpdate {

    public static void EuDbUpdateList () throws Exception {
        String version = DLL.DllVersionCheck("eu");

        DB.setiDbName("aion_eu");
        DB.newInstance();

        String db = "aion_eu";

        // 2. File list
        EuFileList.selectedFiles();

        // 6. execute update commands (DB)
        TableUpdate.execute();

        // 7. dump the db (CMD)
        DumpDb.execute("aion_eu_" + version, "aion_eu");

        // 8. zip the dump (CMD)
        ZipDump.execute("aion_eu_" + version);

        // 9. upload zip to ftp (FTP)
        UploadDbZip.execute("aion_eu_" + version);

        // 10. unzip dump on server (SSH)
        UnzipDump.execute("aion_eu_" + version);

        // 11. execute source command (DB)
        RestoreDbOnServer.execute("kele01_java_eu", "aion_eu_" + version);

        // 15. remove db files .sql and .zip (FTP)
        RemoveZipSql.execute("aion_eu_" + version);

        DB.execute("UPDATE `aion`.`appdata` SET `data` = '" + version + "' WHERE (`name` = 'euversion');");
    }
}
