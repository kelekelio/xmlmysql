package MediaWiki;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grzegorz Nowakowski
 */
class MediaWikiTest {

    public void createMediawikiArticle() {
        MediaWiki.createArticle("Version:79.20.1201", "{{#Version:79.20.1201}}", "Version:79.20.1201");
    }

}