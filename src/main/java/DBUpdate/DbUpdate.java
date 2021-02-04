package DBUpdate;

import DB.DB;
import Util.*;
import XML.GeneralHandler;
import XML.LanguageHandler;
import XML.VersionHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Grzegorz Nowakowski
 */
public class DbUpdate {

    public static void execute (String db, String version) throws Exception {


        DB.setiDbName(db);
        DB.newInstance();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();
        LanguageHandler languageHandler = new LanguageHandler();



        // 2. File list
        switch (db) {
            case "aion":
                KrFileList.selectedFiles(saxParser, handler, versionHandler, languageHandler);
                break;
            case "aion_eu":
                EuFileList.selectedFiles(saxParser, handler, versionHandler, languageHandler);
                break;
            case "aion_c":
                ClassicFileList.selectedFiles(saxParser, handler, versionHandler, languageHandler);
                break;
            default:
                break;
        }



        // 6. execute update commands (DB)
        TableUpdate.execute();

        // 7. dump the db (CMD)
        DumpDb.execute(db + "_" + version, db);

        // 8. zip the dump (CMD)
        ZipDump.execute(db + "_" + version);

        // 9. upload zip to ftp (FTP)
        UploadDbZip.execute(db + "_" + version);

        // 10. unzip dump on server (SSH)
        UnzipDump.execute(db +"_" + version);

        // 11. execute source command (DB)
        RestoreDbOnServer.execute("kele01_" + db, db + "_" + version);

        // 15. remove db files .sql and .zip (FTP)
        RemoveZipSql.execute(db + "_" + version);


        DB.execute("UPDATE `aion`.`appdata` SET `data` = '" + version + "' WHERE (`name` = '" + db + "');");

    }
}
