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
public class ClassicDbUpdate {

    public static void ClassicDbUpdateList () throws Exception {
        String version = DLL.DllVersionCheck("classic");

        DB.setiDbName("aion_c");
        DB.newInstance().getConn().createStatement();

        String db = "aion_classic";

        // 2. File list
        ClassicFileList.selectedFiles();


        // 6. execute update commands (DB)
        TableUpdate.ExecuteTableUpdate();

        // 7. dump the db (CMD)
        DumpDb.ExecuteDbDump("aion_classic_" + version, "aion_c");

        // 8. zip the dump (CMD)
        ZipDump.ExecuteDumpZip("aion_classic_" + version);

        // 9. upload zip to ftp (FTP)
        UploadDbZip.executeDbZipUpload("aion_classic_" + version);

        // 10. unzip dump on server (SSH)
        UnzipDump.ExecuteDumpUnzip("aion_classic_" + version);

        // 11. execute source command (DB)
        RestoreDbOnServer.ExecuteDbRestorationOnServer("kele01_java_classic", "aion_classic_" + version);

        // 15. remove db files .sql and .zip (FTP)
        RemoveZipSql.ExecuteSqlZipRemoval("aion_classic_" + version);


        DB.execute("UPDATE `aion`.`appdata` SET `data` = '" + version + "' WHERE (`name` = 'classicversion');");

    }

}
