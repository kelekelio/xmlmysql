package DB;

import Errors.Errors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.Set;

public class DB {
    // connect to DB +
    // insert, truncate statements. +
    // insert => INSERT INTO table_name ( keySet() ) VALUES ( values() ) +
    // truncate table before running =>  run method on initial xml node
    // on insert error, check available table columns, compare with keySet(), add missing columns (alter table)

    private final String address = "localhost";
    private String dbname = "java";
    private final String user = "root";
    private final String password = "";

    private static DB instance;
    private Connection conn;

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }

        return instance;
    }


    public DB() {


        String url = "jdbc:mysql://" + address + ":3306/" + dbname;

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

    public static void insert(LinkedHashMap<String, String> sqlArray, String tableName) throws IOException {



        //keys => [id, id2, name, desc, desc1, desc2]
        Set<String> SQLkeys = sqlArray.keySet();
        //System.out.println(SQLkeys);

        //values => ["133345", "1133345", "dev_name", "description", "description1", "description2"]
        Collection<String> SQLvalues = sqlArray.values();
        //System.out.println(SQLvalues);

        String SQLStatement = "REPLACE INTO " + tableName + " "+ SQLkeys +" VALUES "+ SQLvalues +";";


        SQLStatement = SQLStatement
                .replaceAll("\\[", "(")
                .replaceAll("]", ")");

        System.out.println(SQLStatement);

        try {
            Statement st = DB
                    .getInstance()
                    .getConn()
                    .createStatement();

            st.execute(SQLStatement);
            st.close();
        } catch (SQLException throwables) {
            //if error, check columns

            // 1062 => DUPLICATE KEY
            if (throwables.getErrorCode() == 1062) {
                System.out.println("ID already exists");
            }
            // 1146 Table doesn't exist
            else if (throwables.getErrorCode() == 1146) {
                System.out.println("Table doesn't exist. Creating the table from a new.");
                loadTableCreate(tableName);
                System.out.println("Inserting data again.");
                insert(sqlArray, tableName);
            }
            // 1054 => UNKNOWN COLUMN
            else if (throwables.getErrorCode() == 1054) {
                // todo: on column missing, initiate creation of new table creation file based on all mapped nodes
                // Create column compare method
                System.out.println("Unknown column. Error " + throwables.getErrorCode());
            }

            else {
                System.out.println(throwables.getErrorCode());
            }

        }
    }

    public static void truncate (String tableName) throws IOException {
        // execute on initial xml tag (or 1st ID)

        try {

            Statement st = DB
                    .getInstance()
                    .getConn()
                    .createStatement();

            st.execute("TRUNCATE " + tableName + ";");
            st.close();
            System.out.println(tableName + " has been cleared.");
        } catch (SQLException throwables) {

            //if error, create table
            // 1146 => table doesn't exist
            if (throwables.getErrorCode() == 1146) {
                System.out.println("Table doesn't exist, create the table from a new");
                //create table method
                //on closing xml tag, create a new CREATE TABLE sql file =>
                // store all unique xml nodes, get their last known type (SHOW COLUMNS FROM table_name;), else use text for all but ID
                //create/overwrite SQLcreate file
                loadTableCreate(tableName);
            }
        }
    }

    public static void execute (String sqlStatement) {

        try {
            Statement st = DB
                    .getInstance()
                    .getConn()
                    .createStatement();

            st.execute(sqlStatement);
            st.close();
        } catch (SQLException throwables) {
            if (throwables.getErrorCode() == 1050) {
                System.out.println("Table already exists. Error: " + throwables.getErrorCode());
            }else {
                System.out.println("Error: " + throwables.getErrorCode());
            }
        }

    }





    public static void loadTableCreate (String tableName) throws IOException {




        String s;
        StringBuilder sb = new StringBuilder();
        String[] inst = new String[0];

        try {
            FileReader fr = new FileReader(new File("src//main//resources//sqlTables//" + tableName + ".sql"));
            BufferedReader br = new BufferedReader(fr);

            while((s = br.readLine()) != null)
            {
                sb.append(s);
            }
            br.close();

            inst = sb.toString().split(";");

            for (String value : inst) {

                if (!value.trim().equals("")) {


                    System.out.println(">>" + value);
                    execute(value);
                }
            }

        }
        catch(Exception e) {
            System.out.println("Scheme doesn't exist. Using a default scheme.");

            String SQLStatement = "CREATE TABLE " + tableName + " (\n" +
                    " id int(15) NOT NULL,\n" +
                    " name varchar(255) NOT NULL,\n" +
                    " PRIMARY KEY (id),\n" +
                    " KEY `name` (`name`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

            execute(SQLStatement);

        }

    }




    public Connection getConn() {
        return conn;
    }

}
