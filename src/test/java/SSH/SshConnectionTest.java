package SSH;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * @author Grzegorz Nowakowski
 */
class SshConnectionTest {

    @Test
    void execQuery() throws SQLException {
        SshConnection ssh = new SshConnection();
        ssh.execute("ls -la");
        ssh.closeSSH();
    }

    @Test
    void execUpdateQuery() throws SQLException, InterruptedException {
        SshConnection ssh = new SshConnection();
        ssh.execute("ls -la");

        ssh.execute("unzip -o public_html/java/aion_79.20.1109.zip -d public_html/java/");
        ssh.execute("ls -la\n");
        System.out.println("wait");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("end");

        ssh.execute("mysql --host=192.168.101.74 --port=3306 -u kele01_java2 -pr.Wva-]p]ns+ kele01_java < public_html/java/aion_79.20.1109.sql");
        ssh.closeSSH();
    }
}