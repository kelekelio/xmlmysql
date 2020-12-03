package MediaWiki;

import Extra.Config;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;

/**
 * @author Grzegorz Nowakowski
 */
public class MediaWiki {



    public static void createArticle(String title, String text, String summary) {
        MediaWikiBot wikiBot = new MediaWikiBot(Config.WIKI_URL);
        wikiBot.login(Config.WIKI_USER, Config.WIKI_PASS);

        Article article = new Article(wikiBot, title);
        article.addText(text);
        article.save(summary);
    }

    static void applyChangesTo(Article article) {
        // edits the article...
    }

}
