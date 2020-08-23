import DB.DB;
import XML.GeneralHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {


        //LinkedHashMap<String, String> xml = new LinkedHashMap<String, String>();

        //xml.put("id", "\"2\"");
        //xml.put("name", "\"icon_shop_item_preset_default\"");

        //DB.insert(xml, "client_goods_icon");


        //DB.truncate("yyyyy");

        //DB.loadTableCreate("client_goods_icon");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        GeneralHandler handler = new GeneralHandler();

        saxParser.parse(new File("P:/Java/xmlmysql/src/main/resources/xml/client_goods_icon.xml"), handler);


    }
}
