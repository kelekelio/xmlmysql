package DBUpdate;

import CMD.Cmd;
import DB.DB;
import DLL.DLL;
import FTP.FTPFunctions;
import SSH.Exec;
import SSH.SshConnection;
import Util.*;
import XML.GeneralHandler;
import XML.VersionHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import static Extra.Colors.ANSI_RED;
import static Extra.Colors.ANSI_RESET;
import static Extra.Config.*;

/**
 * @author Grzegorz Nowakowski
 */
public class EuDbUpdate {

    public static void EuDbUpdateList () throws Exception {
        String version = DLL.DllVersionCheck("eu");

        DB.setiDbName("aion_eu");
        DB.newInstance().getConn().createStatement();

        String db = "aion_eu";

        // 2. File list
        EuFileList.selectedFiles();

        // 6. execute update commands (DB)
        TableUpdate.ExecuteTableUpdate();

        // 7. dump the db (CMD)
        DumpDb.ExecuteDbDump("aion_eu_" + version, "aion_eu");

        // 8. zip the dump (CMD)
        ZipDump.ExecuteDumpZip("aion_eu_" + version);

        // 9. upload zip to ftp (FTP)
        UploadDbZip.executeDbZipUpload("aion_eu_" + version);

        // 10. unzip dump on server (SSH)
        UnzipDump.ExecuteDumpUnzip("aion_eu_" + version);

        // 11. execute source command (DB)
        RestoreDbOnServer.ExecuteDbRestorationOnServer("kele01_java_eu", "aion_eu_" + version);

        // 15. remove db files .sql and .zip (FTP)
        RemoveZipSql.ExecuteSqlZipRemoval("aion_eu_" + version);

        DB.execute("UPDATE `aion`.`appdata` SET `data` = '" + version + "' WHERE (`name` = 'euversion');");
    }
}
