package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.Set;

public class DB {
    // connect to DB
    // insert, replace, truncate statements.
    // insert and replace => INSERT INTO table_name ( keySet() ) VALUES ( values() )
    // truncate table before running
    // on insert replace error, check available table columns, compare with keySet(), add missing columns (alter table)

    private static DB instance;
    private Connection conn;
    private static Set<String> SQLkeys;
    private static Collection<String> SQLvalues;



    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }

        return instance;
    }


    public DB() {
        String adress = "localhost";
        String dbname = "java";
        String user = "root";
        String password = "";

        String url = "jdbc:mysql://" + adress + ":3306/" + dbname;

        Properties prop = new Properties();
        prop.put("password", password);
        prop.put("user", user);
        prop.put("serverTimezone", "Europe/Warsaw");
        prop.put("useUnicode", true);
        prop.put("characterEncoding", "utf-8");

        try {
            conn = DriverManager.getConnection(url, prop);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insert(LinkedHashMap<String, String> sqlArray, String table_name) {

        SQLkeys = sqlArray.keySet();
        System.out.println(SQLkeys);

        SQLvalues = sqlArray.values();
        System.out.println(SQLvalues);

        try {
            PreparedStatement st = DB
                    .getInstance()
                    .getConn()
                    .prepareStatement("INSERT INTO table_name () values ();");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




    public Connection getConn() {
        return conn;
    }

}
