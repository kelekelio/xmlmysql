package DLL;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.VerRsrc;
import com.sun.jna.platform.win32.Version;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.io.File;

public class DLL {

    /*
    final private static String krDLL = "P:/PlayNC/AION_KOR_TEST/bin64/Game.dll";
    final private static String euDLL = "P:/Program Files (x86)/AION QA1/bin64/Game.dll";
     */

    final private static String euDLL = "src\\main\\resources\\dll\\CrySystem.dll";
    final private static String krDLL = "src\\main\\resources\\dll\\CrySystem.dll";


    public static String DllVersionCheck (String region) {
        File fileToCheck;

        if (region.equals("eu")){
            fileToCheck = new File(euDLL);
        }else {
            fileToCheck = new File(krDLL);
        }

        short[] rtnData = new short[4];

        int infoSize =
                Version.INSTANCE.GetFileVersionInfoSize(fileToCheck.getAbsolutePath(), null);
        Pointer buffer = Kernel32.INSTANCE.LocalAlloc(WinBase.LMEM_ZEROINIT, infoSize);

        try {
            Version.INSTANCE.GetFileVersionInfo(fileToCheck.getAbsolutePath(), 0, infoSize, buffer);
            IntByReference outputSize = new IntByReference();
            PointerByReference pointer = new PointerByReference();
            Version.INSTANCE.VerQueryValue(buffer, "\\", pointer, outputSize);
            VerRsrc.VS_FIXEDFILEINFO fileInfoStructure = new VerRsrc.VS_FIXEDFILEINFO(pointer.getValue());

            // product version
            rtnData[0] = (short) (fileInfoStructure.dwProductVersionMS.longValue() >> 16);
            rtnData[1] = (short) (fileInfoStructure.dwProductVersionMS.longValue() & 0xffff);
            rtnData[2] = (short) (fileInfoStructure.dwProductVersionLS.longValue() >> 16);
            rtnData[3] = (short) (fileInfoStructure.dwProductVersionLS.longValue() & 0xffff);


            return dump(rtnData, region);

        }
        finally  {
            Kernel32.INSTANCE.GlobalFree(buffer);
        }
    }

    public static String dump(short [] data, String region) {
        //Product version => Kr: 77.20.806.15981 / EU: 7520.311.714.555685
        String month = String.format("%04d", data[2]).substring(0, 4);
        String version = "" + data[0];


        if (region.equals("eu")) {
            String majorVersion = version.substring(0, (version.length()/2));
            String yearVersion = version.substring((version.length()/2));
            return majorVersion + "." + yearVersion + "." + month;
        }else {
            return data[0] + "." + data[1] + "." + month;
        }
    }
}
