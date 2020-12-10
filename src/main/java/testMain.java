import net.sourceforge.jwbf.core.bots.WikiBot;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;

import java.util.*;

/**
 * @author Grzegorz Nowakowski
 */
public class testMain {



    public static void main(String[] args) {

        LinkedHashMap<String, String> xmlMap = new LinkedHashMap<>();

        xmlMap.put("id", "1");
        xmlMap.put("name", "\"STR_F2P_SHOP_LINK003\"");
        xmlMap.put("body", "\"[%shoplink]\"");


        Set<String> SQLkeys = xmlMap.keySet();
        String joined = String.join(",", SQLkeys);


        Collection<String> SQLvalues = xmlMap.values();

        String joinedv = String.join(",", SQLvalues);

        System.out.println(SQLkeys);
        System.out.println(SQLvalues);
        System.out.println(joined);
        System.out.println(joinedv);



    }

    static void applyChangesTo(Article article) {
        // edits the article...
    }
}
