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
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        GeneralHandler handler = new GeneralHandler();

        ArrayList<String> ignoreList = new ArrayList<>();



        /*
        handler.setInitialNode("client_goods_icons");
        handler.setTableName("client_goods_icon");
        //saxParser.parse(new File("P:/Java/xmlmysql/src/main/resources/xml/client_goods_icon.xml"), handler);

        saxParser.parse(new File("D:/PB/data_eu/goods/client_goods_icon.xml"), handler);


        handler.setInitialNode("client_pcraces");
        handler.setTableName("client_pcrace");
        saxParser.parse(new File("D:/PB/data/pc/client_PCRace.xml"), handler);

*/

        //TODO: declare a separate ignore list in a ArrayList<ArrayList<>>


        ignoreList.add("bonus_attrs");
        ignoreList.add("data");
        handler.setIgnoreList(ignoreList);
        handler.setTruncate(false);
        handler.setInitialNode("client_abyss_race_bonuss");
        handler.setTableName("client_abyss_race_bonus");
        saxParser.parse(new File("D:/PB/data/pc/abyss_race_bonuses.xml"), handler);


        /*
        LinkedHashMap<String, ArrayList<String>> nodeIgnoreList = new LinkedHashMap<>();
        nodeIgnoreList.put("name", ("node1", "node2"));
        nodeIgnoreList.put("name1", ("node1", "node2"));


         */

    }
}
