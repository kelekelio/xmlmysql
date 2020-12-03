import net.sourceforge.jwbf.core.bots.WikiBot;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
public class testMain {



    public static void main(String[] args) {

        MediaWikiBot wikiBot = new MediaWikiBot("https://aionpowerbook.com/powerbook/");
        wikiBot.login("Kelekelio", "pdc3wav9mlog");
        Article article = new Article(wikiBot, "Version:79.20.1201");

        //System.out.println(wikiBot.getVersion());

        article.addText("{{#Version:79.20.1201}}");
        article.save("Version:79.20.1201");



    }

    static void applyChangesTo(Article article) {
        // edits the article...
    }
}
