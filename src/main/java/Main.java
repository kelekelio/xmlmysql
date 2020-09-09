import DLL.DLL;
import Discord.DiscordWebhook;
import SSH.UserAuthPubKey;
import XML.GeneralHandler;
import XML.VersionHandler;
import com.jcraft.jsch.JSchException;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {



    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, JSchException {
        long startTime = System.nanoTime();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        GeneralHandler handler = new GeneralHandler();
        VersionHandler versionHandler = new VersionHandler();

        ArrayList<String> ignoreList = new ArrayList<>();



        System.out.println("ssh wipe");
        UserAuthPubKey ssh = new UserAuthPubKey();
        ssh.executeSSH(ssh.getSession(), "find public_html/java/testdelete/ -type f -name \"*.html\" -delete");
        System.out.println("ssh wipe done");





        DiscordWebhook webhook = new DiscordWebhook("https://discordapp.com/api/webhooks/710484134773915648/VYvTlgWV-0hOIm04wbzpQg6o5vXmvYzegTvX0Ap1eqQjcRwuPBtHQ3nFDuQaE0dwqF_R");
        webhook.setUsername("Aion is Dead");
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
            .setTitle("Version Update")
            .setDescription("New game version detected!")
            .setColor(Color.RED)
            .addField("KR", DLL.DllVersionCheck("kr"), true)
            .addField("EU", DLL.DllVersionCheck("eu"), true)
            .setThumbnail("https://kryptongta.com/images/kryptonlogo.png")
            .setFooter("Update initiated. Estimated downtime: 5min", "")
            .setUrl("https://aionpowerbook.com/powerbook/Version"));
        webhook.execute(); //Handle exception

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




        long elapsedTime = System.nanoTime() - startTime;
        long convert = TimeUnit.MINUTES.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println(convert);
    }
}
