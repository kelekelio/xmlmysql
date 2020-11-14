package DBUpdate;

import DB.DB;
import DLL.DLL;
import FTP.FTPFunctions;
import Util.*;
import XML.GeneralHandler;
import XML.VersionHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;

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
        TableUpdate.ExecuteTableUpdate();

        // 7. dump the db (CMD)
        DumpDb.ExecuteDbDump("aion_" + version, "aion");

        // 8. zip the dump (CMD)
        ZipDump.ExecuteDumpZip("aion_" + version);

        // 9. upload zip to ftp (FTP)
        UploadDbZip.executeDbZipUpload("aion_" + version);

        // 10. unzip dump on server (SSH)
        UnzipDump.ExecuteDumpUnzip("aion_" + version);

        // 11. execute source command (DB)
        RestoreDbOnServer.ExecuteDbRestorationOnServer("kele01_java", "aion_" + version);

        // 15. remove db files .sql and .zip (FTP)
        RemoveZipSql.ExecuteSqlZipRemoval("aion_" + version);

        DB.execute("UPDATE `aion`.`appdata` SET `data` = '" + version + "' WHERE (`name` = 'krversion');");

    }
}
