package FTP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FTPFunctionsTest {


    @Test
    void progressPercentage() {
            FTPFunctions.progressPercentage(70, 100);
    }

    @Test
    void uploadFTPFile() throws Exception {
        FTPFunctions ftpobj = new FTPFunctions();
        ftpobj.uploadFTPFile("D:\\wamp64\\bin\\mysql\\mysql5.7.21\\bin\\java.sql", "java.sql", "/public_html/java/");
    }

    @Test
    void downloadFTPFile() {
    }

    @Test
    void deleteFTPFile() {
    }

    @Test
    void disconnect() {
    }
}