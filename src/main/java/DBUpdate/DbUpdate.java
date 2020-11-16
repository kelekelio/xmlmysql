package DBUpdate;

import DB.DB;
import DLL.DLL;
import Util.*;

/**
 * @author Grzegorz Nowakowski
 */
public class DbUpdate {

    public static void execute (String db, String version) throws Exception {


        DB.setiDbName(db);
        DB.newInstance();



        // 2. File list
        switch (db) {
            case "aion":
                KrFileList.selectedFiles();
                break;
            case "aion_eu":
                EuFileList.selectedFiles();
                break;
            case "aion_classic":
                ClassicFileList.selectedFiles();
                break;
            default:
                break;
        }



        // 6. execute update commands (DB)
        TableUpdate.ExecuteTableUpdate();

        // 7. dump the db (CMD)
        DumpDb.ExecuteDbDump(db + "_" + version, db);

        // 8. zip the dump (CMD)
        ZipDump.ExecuteDumpZip(db + "_" + version);

        // 9. upload zip to ftp (FTP)
        UploadDbZip.executeDbZipUpload(db + "_" + version);

        // 10. unzip dump on server (SSH)
        UnzipDump.ExecuteDumpUnzip(db +"_" + version);

        // 11. execute source command (DB)
        RestoreDbOnServer.ExecuteDbRestorationOnServer("kele01_" + db, db + "_" + version);

        // 15. remove db files .sql and .zip (FTP)
        RemoveZipSql.ExecuteSqlZipRemoval(db + "_" + version);


        DB.execute("UPDATE `aion`.`appdata` SET `data` = '" + version + "' WHERE (`name` = '" + db + "');");

    }
}
