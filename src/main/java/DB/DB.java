package DB;

import Errors.Errors;

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
    private final String dbname = "java";
    private final String user = "root";
    private final String password = "";

    private static DB instance;
    private Connection conn;


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

    public static void insert(LinkedHashMap<String, String> sqlArray, String tableName, String insertionType) {



        //keys => [id, id2, name, desc, desc1, desc2]
        Set<String> SQLkeys = sqlArray.keySet();
        System.out.println(SQLkeys);

        //values => ["133345", "1133345", "dev_name", "description", "description1", "description2"]
        Collection<String> SQLvalues = sqlArray.values();
        System.out.println(SQLvalues);

        String SQLStatement = insertionType + " INTO " + tableName + " "+ SQLkeys +" VALUES "+ SQLvalues +";";


        SQLStatement = SQLStatement.replaceAll("\\[", "(").replaceAll("]", ")");

        System.out.println(SQLStatement);

        try {
            Statement st = DB
                    .getInstance()
                    .getConn()
                    .createStatement();

            st.execute(SQLStatement);
            st.close();
        } catch (SQLException throwables) {
            //TODO: use errorHanlder for errors
            //if error, check columns

            // 1062 => DUPLICATE KEY
            if (throwables.getErrorCode() == 1062) {
                System.out.println("ID already exists");
                insert(sqlArray, tableName, "REPLACE");
            }
            // 1054 => UNKNOWN COLUMN
            else if (throwables.getErrorCode() == 1054) {
                // Create column compare method
                System.out.println("Unknown column");
            }
            else {
                System.out.println(throwables.getErrorCode());
            }

        }
    }

    public static void truncate (String tableName) {
        try {

            Statement st = DB
                    .getInstance()
                    .getConn()
                    .createStatement();

            st.execute("TRUNCATE " + tableName + ";");
            st.close();
        } catch (SQLException throwables) {

            //if error, create table
            // 1146 => table doesn't exist
            if (throwables.getErrorCode() == 1146) {
                System.out.println("Table doesn't exist, create the table from a new");
                //create table method
                //on closing xml tag, create a new CREATE TABLE txt file =>
                // store all unique xml nodes, get their last known type (SHOW COLUMNS FROM table_name;), else use text for all but ID
                //create/overwrite SQLcreate file
                createTable(tableName);
            }
        }
    }



    public static void createTable (String tableName) {



        //TODO: load statement from file
        String SQLStatement = "CREATE TABLE " + tableName + " (\n" +
                " id int(15) NOT NULL,\n" +
                " name varchar(255) NOT NULL,\n" +
                " PRIMARY KEY (id),\n" +
                " KEY `name` (`name`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

        //test
        System.out.println(SQLStatement);

        try {
            Statement st = DB
                    .getInstance()
                    .getConn()
                    .createStatement();

            st.execute(SQLStatement);
            st.close();

            //TODO: test, replace with errorHandler
            System.out.println(tableName + " has been created.");

        } catch (SQLException throwables) {

            Errors.errorHandler("sql", throwables.getErrorCode(), tableName);

        }


    }




    public Connection getConn() {
        return conn;
    }

}
