package DB;

import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class DBTest {

    @Test
    void insert() throws SQLException, IOException {
        LinkedHashMap<String, String> xml = new LinkedHashMap<String, String>();

        xml.put("id", "\"2\"");
        xml.put("name", "\"icon_shop_item_preset_default\"");

        DB.insert(xml, "client_goods_icon");

        //Check if ID was inserted
        ResultSet results = DB
                .getInstance()
                .getConn()
                .createStatement()
                .executeQuery("select id, name from client_goods_icon where id = 2");

        if (results.next()) {
            assertEquals(2, results.getInt("id"));
            assertEquals("\"icon_shop_item_preset_default\"", "\"" + results.getString("name") + "\"");
        }
        results.close();


        // Delete inserted test ID
        Statement delete = DB
                .getInstance()
                .getConn()
                .createStatement();

        delete.execute("delete from testaion where id = 2");
        delete.close();

    }

    @Test
    void truncate() throws IOException, SQLException {
        int expected = 0;
        int returned = 0;
        DB.truncate("client_goods_icon");



        ResultSet results = DB
                .getInstance()
                .getConn()
                .createStatement()
                .executeQuery("SELECT COUNT(*) as count FROM client_goods_icon");

        while (results.next()) {
            returned = results.getInt("count");
        }


        assertEquals(expected, returned);

    }

    @Test
    void loadTableCreate() throws IOException {
        DB.loadTableCreate("tuuuj");
    }
}