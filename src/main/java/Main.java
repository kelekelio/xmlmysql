import DB.DB;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        LinkedHashMap<String, String> xml = new LinkedHashMap<String, String>();

        xml.put("id", "\"133966677\"");
        xml.put("id2", "\"1133345\"");
        xml.put("name", "\"dev_name\"");
        xml.put("desc1", "\"description1\"");
        xml.put("desc2a", "\"description2\"");

        //DB.insert(xml, "testaion", "INSERT");


        //DB.truncate("yyyyy");

        DB.createTable("testCreate1");



    }
}
