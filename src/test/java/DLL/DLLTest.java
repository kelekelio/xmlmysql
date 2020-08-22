package DLL;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DLLTest {

    private Object DLLFileVersionInfo;

    @Test
    public void dllVersionCheckEU() {
        String expected = "75.20.0714";
        String version = DLL.DllVersionCheck("eu");
        System.out.println(version);
        Assert.assertEquals(expected, version);
    }

    @Test
    void dllVersionCheckKR() {
        String expected = "77.20.0806";
        String version = DLL.DllVersionCheck("kr");
        System.out.println(version);
        Assert.assertEquals(expected, version);
    }

    @Test
    void dump() {
        short[] data = {77, 20, 611, 1122};
        String expected = "77.20.0611";
        String version = DLL.dump(data, "kr");
        Assert.assertEquals(expected, version);
    }
}