package MediaWiki;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grzegorz Nowakowski
 */
class MediaWikiTest {

    @Test
    public void createMediawikiArticle() {
        MediaWiki.createArticle("79.20.1266", "aion");
    }

    @Test
    public void editMainPage() {
        MediaWiki.editMainPage("79.20.1266", "1.20.1203", "79.20.1201", "1.20.1124");
    }

}