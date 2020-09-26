package SSH;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

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
}