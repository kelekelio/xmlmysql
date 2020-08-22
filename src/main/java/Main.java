import DB.DB;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        LinkedHashMap<String, String> xml = new LinkedHashMap<String, String>();

        xml.put("id", "\"2\"");
        xml.put("name", "\"icon_shop_item_preset_default\"");

        //DB.insert(xml, "client_goods_icon");


        //DB.truncate("yyyyy");

        DB.loadTableCreate("client_goods_icon");



    }
}
