package DB;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.util.*;
import static Extra.Colors.*;
import static Extra.Config.*;

public class DB {
    // connect to DB +
    // insert, truncate statements. +
    // insert => INSERT INTO table_name ( keySet() ) VALUES ( values() ) +
    // truncate table before running =>  run method on initial xml node
    // on insert error, check available table columns, compare with keySet(), add missing columns (alter table)



    private static DB instance;
    private static int alters;
    private Connection conn;
    private static String iDbName = IDB_NAME;

    public static String getiDbName() {
        return iDbName;
    }

    public static void setiDbName(String iDbName) {
        DB.iDbName = iDbName;
    }

    public static int getAlters() {
        return alters;
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }

        return instance;
    }

    public static DB newInstance() {
        instance = new DB();
        return instance;
    }


    public DB() {


        String url = "jdbc:mysql://" + IDB_HOST + ":3306/" + iDbName;

        Properties prop = new Properties();
        prop.put("password", IDB_PASS);
        prop.put("user", IDB_USER);
        prop.put("serverTimezone", "Europe/Warsaw");
        prop.put("useUnicode", true);
        prop.put("characterEncoding", "utf-8");

        try {
            conn = DriverManager.getConnection(url, prop);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insert(LinkedHashMap<String, String> sqlArray, String tableName) throws IOException, SQLException {

        //keys => [id, id2, name, desc, desc1, desc2]
        Set<String> SQLkeys = sqlArray.keySet();
        //System.out.println(SQLkeys);

        //values => ["133345", "1133345", "dev_name", "description", "description1", "description2"]
        Collection<String> SQLvalues = sqlArray.values();
        //System.out.println(SQLvalues);

        String SQLStatement = "INSERT INTO " + tableName + " "+ SQLkeys +" VALUES "+ SQLvalues +";";


        //replace into [id, id2, name, desc, desc1, desc2] values ["133345", "1133345", "dev_name", "description", "description1", "description2"]

        SQLStatement = SQLStatement
                .replaceAll("\\[", "(")
                .replaceAll("]", ")");

        System.out.println(ANSI_GREEN + ">> " + SQLStatement + ANSI_RESET);

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
                System.out.println(ANSI_RED + "ID already exists. Error: " + throwables.getErrorCode() + ANSI_RESET);
            }
            // 1146 Table doesn't exist
            else if (throwables.getErrorCode() == 1146) {
                System.out.println(ANSI_RED + "Table doesn't exist. Creating the table from a new. Error " + throwables.getErrorCode() + ANSI_RESET);
                loadTableCreate(tableName);
                System.out.println("Inserting data again.");
                insert(sqlArray, tableName);
            }
            // 1054 => UNKNOWN COLUMN
            else if (throwables.getErrorCode() == 1054) {
                System.out.println(ANSI_RED + "Unknown column. Error " + throwables.getErrorCode() + ANSI_RESET);
                Set<String> tempColumns = new HashSet<>(SQLkeys);

                ResultSet results = DB
                        .getInstance()
                        .getConn()
                        .createStatement()
                        .executeQuery("SHOW COLUMNS FROM " + tableName);

                while (results.next()) {
                    tempColumns.remove(results.getString("Field"));
                }

                for (String column : tempColumns) {
                    alterTable(tableName, column, sqlArray.get(column));
                }
                results.close();

                System.out.println("Inserting data again.");
                insert(sqlArray, tableName);

            }

            else {
                System.out.println(ANSI_RED + "Error " + throwables.getErrorCode() + ANSI_RESET);
            }

        }
    }

    public static void replace (LinkedHashMap<String, String> sqlArray, String tableName) throws IOException, SQLException {

        //keys => [id, id2, name, desc, desc1, desc2]
        Set<String> SQLkeys = sqlArray.keySet();
        //System.out.println(SQLkeys);

        //values => ["133345", "1133345", "dev_name", "description", "description1", "description2"]
        Collection<String> SQLvalues = sqlArray.values();
        //System.out.println(SQLvalues);

        String SQLStatement = "REPLACE INTO " + tableName + " "+ SQLkeys +" VALUES "+ SQLvalues +";";


        //replace into [id, id2, name, desc, desc1, desc2] values ["133345", "1133345", "dev_name", "description", "description1", "description2"]

        SQLStatement = SQLStatement
                .replaceAll("\\[", "(")
                .replaceAll("]", ")");

        System.out.println(ANSI_GREEN + ">> " + SQLStatement + ANSI_RESET);

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
                System.out.println(ANSI_RED + "ID already exists. Error: " + throwables.getErrorCode() + ANSI_RESET);
            }
            // 1146 Table doesn't exist
            else if (throwables.getErrorCode() == 1146) {
                System.out.println(ANSI_RED + "Table doesn't exist. Creating the table from a new. Error " + throwables.getErrorCode() + ANSI_RESET);
                loadTableCreate(tableName);
                System.out.println("Inserting data again.");
                insert(sqlArray, tableName);
            }
            // 1054 => UNKNOWN COLUMN
            else if (throwables.getErrorCode() == 1054) {
                System.out.println(ANSI_RED + "Unknown column. Error " + throwables.getErrorCode() + ANSI_RESET);
                Set<String> tempColumns = new HashSet<>(SQLkeys);

                ResultSet results = DB
                        .getInstance()
                        .getConn()
                        .createStatement()
                        .executeQuery("SHOW COLUMNS FROM " + tableName);

                while (results.next()) {
                    tempColumns.remove(results.getString("Field"));
                }

                for (String column : tempColumns) {
                    //execute("ALTER TABLE " + tableName + " ADD COLUMN " + column + " TEXT NULL;");
                    alterTable(tableName, column, sqlArray.get(column));
                }
                results.close();

                System.out.println("Inserting data again.");
                insert(sqlArray, tableName);

            }

            else {
                System.out.println(ANSI_RED + "Error " + throwables.getErrorCode() + ANSI_RESET);
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
                System.out.println(ANSI_RED + "Table doesn't exist, create the table from a new. Error " + throwables.getErrorCode() + ANSI_RESET);
                //create table method
                //on closing xml tag, create a new CREATE TABLE sql file =>
                // store all unique xml nodes, get their last known type (SHOW COLUMNS FROM table_name;), else use text for all but ID
                //create/overwrite SQLcreate file
                loadTableCreate(tableName);
            }
        }
    }

    public static void alterTable (String tableName, String columnName, String columnValue) {

        String textToFile = tableName + " => " + columnName + " : " + columnValue + "\n";


            try {
                File myObj = new File("P:\\AlterTables.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    Files.write(Paths.get("P:\\AlterTables.txt"), textToFile.getBytes(), StandardOpenOption.APPEND);
                    alters++;
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        execute("ALTER TABLE " + tableName + " ADD COLUMN " + columnName + " TEXT NULL;");



    }

    public static void execute (String sqlStatement) {

        try {
            System.out.println(ANSI_GREEN + ">> " + sqlStatement + ANSI_RESET);
            Statement st = DB
                    .getInstance()
                    .getConn()
                    .createStatement();

            st.execute(sqlStatement);
            st.close();
        } catch (SQLException throwables) {
            if (throwables.getErrorCode() == 1050) {
                System.out.println(ANSI_RED + "Table already exists. Error: " + throwables.getErrorCode() + ANSI_RESET);
            } else if (throwables.getErrorCode() == 1064) {
                System.out.println(ANSI_RED + "Syntax error. Error: " + throwables.getErrorCode() + ANSI_RESET);
            } else if (throwables.getErrorCode() == 1062) {
                System.out.println(ANSI_RED + "ID already exists. Error: " + throwables.getErrorCode() + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Error: " + throwables.getErrorCode() + ANSI_RESET);
            }
        }

    }


    public static String returnValue (String table, String columnBy, String value, String columnLook) {
        try {
            String statement = "SELECT "+columnLook+" FROM "+table+" WHERE "+columnBy+" = \""+value+"\" ";
            ResultSet resultseu = DB
                    .getInstance()
                    .getConn()
                    .createStatement()
                    .executeQuery(statement);
            if (resultseu.next()) {
                String result = resultseu.getString(columnLook);
                resultseu.close();
                return result;
            }
        } catch (SQLException e) {

        }
        return "";
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
