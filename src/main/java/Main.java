import XML.GeneralHandler;
import XML.VersionHandler;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
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
        VersionHandler versionHandler = new VersionHandler();

        ArrayList<String> ignoreList = new ArrayList<>();



        //apache





        //TODO: set the list of files in a file????
        // <file_url></file_url>
        // <handler></handler>
        // <IgnoreList></IgnoreList>
        // <InitialNode></InitialNode>
        // <TableName></TableName>
        // <Truncate></Truncate>
        // <consolidate></consolidate>




/*
        ignoreList.add("bonus_attrs");
        ignoreList.add("data");
        handler.setIgnoreList(ignoreList);
        handler.setTruncate(false);
        handler.setInitialNode("client_abyss_race_bonuss");
        handler.setTableName("client_abyss_race_bonus");
        saxParser.parse(new File("D:\\PB\\data\\pc\\abyss_race_bonuses.xml"), handler);




        handler.setInitialNode("client_pcraces");
        handler.setTableName("client_pcrace");
        saxParser.parse(new File("D:\\PB\\data\\pc\\client_PCRace.xml"), handler);


        handler.setInitialNode("client_item_collection_attrs");
        handler.setTableName("client_item_collection_attr");
        saxParser.parse(new File("D:\\PB\\data\\pc\\client_item_collection_attr.xml"), handler);


        handler.setInitialNode("client_jumping_quickbars");
        handler.setTableName("client_jumping_quickbar");
        saxParser.parse(new File("D:\\PB\\data\\pc\\client_jumping_quickbar.xml"), handler);

        handler.setInitialNode("client_ride_datas");
        handler.setTableName("client_ride_data");
        saxParser.parse(new File("D:\\PB\\data\\rides\\rides.xml"), handler);





        versionHandler.setRegion("kr");
        versionHandler.setInitialNode("client_ride_datas");
        versionHandler.setTableName("client_ride_data");
        saxParser.parse(new File("D:\\PB\\data\\rides\\rides.xml"), versionHandler);

        versionHandler.setRegion("eu");
        versionHandler.setInitialNode("client_ride_datas");
        versionHandler.setTableName("client_ride_data");
        saxParser.parse(new File("D:\\PB\\data\\rides\\rides.xml"), versionHandler);







        //files too large to be pushed to github.

        versionHandler.setRegion("kr");
        versionHandler.setInitialNode("client_items");
        versionHandler.setTableName("client_item");
        saxParser.parse(new File("D:/PB/data/items/client_items_etc_1.xml"), versionHandler);
        saxParser.parse(new File("D:/PB/data/items/client_items_etc_2.xml"), versionHandler);
        versionHandler.setRegion("eu");
        saxParser.parse(new File("D:/PB/data_eu/items/client_items_etc_2.xml"), versionHandler);


         */



    }
}
