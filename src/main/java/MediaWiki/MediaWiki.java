package MediaWiki;

import Extra.Config;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;

import static Extra.Colors.*;

/**
 * @author Grzegorz Nowakowski
 */
public class MediaWiki {



    public static void createArticle(String version, String database) {
        MediaWikiBot wikiBot = new MediaWikiBot(Config.WIKI_URL);
        wikiBot.login(Config.WIKI_USER, Config.WIKI_PASS);

        String title = pageTitle(version);
        String text = pageText(version, database);
        String summary = pageSummary(version);


        if (!wikiBot.getArticle(title).getRevisionId().isEmpty()) {
            System.out.println(ANSI_RED + ">> " + title + " Page already exists." + ANSI_RESET);
        } else {
            Article article = new Article(wikiBot, title);
            article.addText(text);
            article.save(summary);
            System.out.println(ANSI_GREEN + ">> Page (" + title + ") has been created." + ANSI_RESET);
        }



    }

    public static void editMainPage (String krVersion, String classicVersion, String previousKrVersion, String previousClassicVersion ) {
        MediaWikiBot wikiBot = new MediaWikiBot(Config.WIKI_URL);
        wikiBot.login(Config.WIKI_USER, Config.WIKI_PASS);

        Article article = new Article(wikiBot, "Main Page");
        String text = article.getText().replaceAll(previousKrVersion, krVersion).replaceAll(previousClassicVersion, classicVersion);

        article.setText(text);
        article.setMinorEdit(true);
        article.save();

        System.out.println(ANSI_GREEN + ">> The Main Page has been updated." + ANSI_RESET);
    }

    static void applyChangesTo(Article article) {
        // edits the article...
    }

    static String pageText (String version, String database) {
        if (database.equals("aion_classic")) {
            return "{{DISPLAYTITLE: Version:" + version + " (Classic Server)}}\n" + "{{#Version:" + version + "|1}}";
        } else {
            return "{{#Version:" + version + "}}";
        }
    }

    static String pageTitle (String version) {
        return "Version:" + version;
    }

    static String pageSummary (String version) {
        return "Version:" + version;
    }

}
