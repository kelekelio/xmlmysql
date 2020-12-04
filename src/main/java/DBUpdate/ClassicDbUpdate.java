package DBUpdate;

import DB.DB;
import DLL.DLL;
import Util.*;

/**
 * @author Grzegorz Nowakowski
 */
public class ClassicDbUpdate {

    public static void ClassicDbUpdateList () throws Exception {
        String version = DLL.DllVersionCheck("classic");

        DB.setiDbName("aion_c");
        DB.newInstance();

        String db = "aion_classic";

        // 2. File list
        ClassicFileList.selectedFiles();


        // 6. execute update commands (DB)
        TableUpdate.execute();

        // 7. dump the db (CMD)
        DumpDb.execute("aion_classic_" + version, "aion_c");

        // 8. zip the dump (CMD)
        ZipDump.execute("aion_classic_" + version);

        // 9. upload zip to ftp (FTP)
        UploadDbZip.execute("aion_classic_" + version);

        // 10. unzip dump on server (SSH)
        UnzipDump.execute("aion_classic_" + version);

        // 11. execute source command (DB)
        RestoreDbOnServer.execute("kele01_java_classic", "aion_classic_" + version);

        // 15. remove db files .sql and .zip (FTP)
        RemoveZipSql.execute("aion_classic_" + version);


        DB.execute("UPDATE `aion`.`appdata` SET `data` = '" + version + "' WHERE (`name` = 'classicversion');");

    }

}
