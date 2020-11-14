package Extra;

/**
 * @author Grzegorz Nowakowski
 */
public class Configuration {
    //FTP
    public static final String FTP_HOST = "FTP_HOST";
    public static final String FTP_USER = "FTP_USER";
    public static final String FTP_PASS = "FTP_PASS";
    public static final int FTP_PORT = 21;

    //SSH
    public static final String SSH_KEY = "C:\\ssh_private_key.ppk";
    public static final int SSH_PORT = 1;
    public static final String SSH_USER = "SSH_USER";
    public static final String SSH_PASS = "SSH_PASS";
    public static final String SSH_HOST = "SSH_HOST";

    //DB
    public static final String DB_NAME = "DB_NAME";
    public static final String DB_USER = "DB_USER";
    public static final String DB_PASS = "DB_PASS";
    public static final String DB_HOST = "localhost";
    public static final int DB_PORT = 3306;

    //Internal DB
    public static final String  IDB_HOST = "localhost";
    public static final String  IDB_NAME = "aion";
    public static final String  IDB_USER = "root";
    public static final String  IDB_PASS = "";

    //DLL
    public static final String DLL_LOCATION_KR = "P:/PlayNC/AION_KOR_TEST/bin64/Game.dll";
    public static final String DLL_LOCATION_EU = "P:/Program Files (x86)/AION QA1/bin64/Game.dll";
    public static final String DLL_LOCATION_CLASSIC = "P:/PlayNC/AION_CLASSIC/bin64/Game.dll";

    //Discord
    public static final String DISCORD_WEBHOOK = "DISCORD_WEBHOOK";
}
