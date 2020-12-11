package Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grzegorz Nowakowski
 */
class RestoreDbOnServerTest {

    @Test
    void executeRemoteDbRestoration () throws InterruptedException {
        RestoreDbOnServer.execute("kele01_aion_c", "aion_c_1.20.1207");
    }

}