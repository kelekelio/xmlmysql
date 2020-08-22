package DB;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DBTest {

    @Test
    void insert() throws SQLException {
        int id = 93323677;
        String name = "\"dev_name\"";


        String SQLStatement = "INSERT INTO testaion " +
                "(id, name) VALUES " +
                "(" + id + ", " + name + ");";



        //insert
        Statement st = DB.getInstance().getConn().createStatement();
        st.execute(SQLStatement);
        st.close();

        //Check if ID was inserted
        ResultSet results = DB
                .getInstance()
                .getConn()
                .createStatement()
                .executeQuery("select id, name from testaion where id = " + id);

        if (results.next()) {
            assertEquals(id, results.getInt("id"));
            assertEquals(name, "\"" + results.getString("name") + "\"");
        }
        results.close();


        // Delete inserted test ID
        Statement delete = DB
                .getInstance()
                .getConn()
                .createStatement();

        delete.execute("delete from testaion where id = " + id);
        delete.close();

    }

    @Test
    void truncate() {
    }

    @Test
    void createTable() {
    }

    @Test
    void loadTableCreate() throws IOException {
        DB.loadTableCreate("client_goods_icon");
    }
}