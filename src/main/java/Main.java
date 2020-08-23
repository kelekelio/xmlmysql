import DB.DB;
import XML.GeneralHandler;
import XML.IgnoreNodes;
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







        //TODO: declare a separate ignore list in a ArrayList<ArrayList<>>

        //TODO: set the list of files in a file????
        // <file_url></file_url>
        // <handler></handler>
        // <IgnoreList></IgnoreList>
        // <InitialNode></InitialNode>
        // <TableName></TableName>
        // <Truncate></Truncate>
        // <consolidate></consolidate>



        ignoreList.add("bonus_attrs");
        ignoreList.add("data");
        handler.setIgnoreList(ignoreList);
        handler.setTruncate(false);
        handler.setInitialNode("client_abyss_race_bonuss");
        handler.setTableName("client_abyss_race_bonus");
        saxParser.parse(new File("D:/PB/data/pc/abyss_race_bonuses.xml"), handler);


        handler.setInitialNode("client_pcraces");
        handler.setTableName("client_pcrace");
        saxParser.parse(new File("D:/PB/data/pc/client_PCRace.xml"), handler);



    }
}
