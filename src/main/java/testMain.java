import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
public class testMain {



    public static void main(String[] args) {

        LinkedHashMap<String, String> xmlMap = new LinkedHashMap<>();
        List<String> temp = new ArrayList<>();
        temp.add("sword_underpass_pvp_f3_r_80a_7day 1");
        temp.add("polearm_underpass_pvp_f3_r_80a_7day 1");
        temp.add("dagger_underpass_pvp_f3_r_80a_7day 1");



        xmlMap.put("fighter_selectable_item", String.valueOf(temp));

        System.out.println(xmlMap);
        //end fighter_selectable_item
        //add do tempa

    }
}
