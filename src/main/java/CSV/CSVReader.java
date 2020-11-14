package CSV;

import DB.DB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Grzegorz Nowakowski
 */
public class CSVReader {

    public static void main(String[] args) {

        final LinkedHashMap<String, String> xmlMap = new LinkedHashMap<>();

        String csvFile = "D:/PB/data/world/source_sphere.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] npcData = line.split(cvsSplitBy);

                xmlMap.put("name", "\"" + npcData[0] + "\"");
                xmlMap.put("type", "\"" + npcData[1] + "\"");
                xmlMap.put("zone", "\"" + npcData[2] + "\"");
                xmlMap.put("layer", "\"" + npcData[3] + "\"");
                xmlMap.put("x", "\"" + npcData[4] + "\"");
                xmlMap.put("y", "\"" + npcData[5] + "\"");
                xmlMap.put("z", "\"" + npcData[6] + "\"");
                xmlMap.put("r", "\"" + npcData[7] + "\"");

                DB.replace(xmlMap, "source_sphere");

            }


        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
