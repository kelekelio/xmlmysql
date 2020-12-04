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

}