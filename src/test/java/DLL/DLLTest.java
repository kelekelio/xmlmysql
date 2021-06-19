package DLL;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;





class DLLTest {



    @Test
    public void dllVersionCheckEU() {
        String expected = "75.20.0714";
        String version = DLL.DllVersionCheck("eu");
        System.out.println(version);
        Assertions.assertEquals(expected, version);
    }

    @Test
    public void dllVersionCheckClassic() {
        String expected = "1.20.1030";
        String version = DLL.DllVersionCheck("classic");
        System.out.println(version);
        Assertions.assertEquals(expected, version);
    }

    @Test
    void dllVersionCheckKR() {
        String expected = "77.20.0806";
        String version = DLL.DllVersionCheck("kr");
        System.out.println(version);
        Assertions.assertEquals(expected, version);
    }

    @Test
    void dump() {
        short[] data = {77, 20, 611, 1122};
        String expected = "77.20.0611";
        String version = DLL.dump(data, "kr");
        Assertions.assertEquals(expected, version);
    }
}