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
        LinkedHashMap<String, String> xml = new LinkedHashMap<>();

        xml.put("id", "\"2\"");
        xml.put("name", "\"icon_shop_item_preset_default\"");

        DB.insert(xml, "client_goods_icon");

        //Check if ID was inserted
        String test = DB.returnValue("client_goods_icon", "id", "2", "id");
        int testInt = Integer.parseInt(test);



        assertEquals(2, testInt);



        // Delete inserted test ID
        Statement delete = DB
                .getInstance()
                .getConn()
                .createStatement();

        delete.execute("delete from client_goods_icon where id = 2");
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

    @Test
    void returnValue() {
        String test = DB.returnValue("client_familiars", "id", "981022", "evolve_item");
        System.out.println(test);
    }

    @Test
    void getInternalDBName() {

        DB.setiDbName("aion_eu");
        System.out.println(DB.getiDbName());

    }
}