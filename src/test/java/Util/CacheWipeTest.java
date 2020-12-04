package Util;

import org.junit.jupiter.api.Test;

/**
 * @author Grzegorz Nowakowski
 */
class CacheWipeTest {

    @Test
    void wipeHTMLCacheFilesInAFolder() {
        //folder: public_html/java/testdelete/
        CacheWipe.execute();
    }
}