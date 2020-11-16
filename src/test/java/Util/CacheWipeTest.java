package Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grzegorz Nowakowski
 */
class CacheWipeTest {

    @Test
    void wipeHTMLCacheFilesInAFolder() {
        //folder: public_html/java/testdelete/
        CacheWipe.executeCacheWipe();
    }
}