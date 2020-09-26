package SSH;

import com.jcraft.jsch.JSchException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grzegorz Nowakowski
 */
class UserAuthPubKeyTest {
    UserAuthPubKey ssh = new UserAuthPubKey();

    @Test
    void executeSSH() throws IOException, JSchException {
        ssh.executeSSH(ssh.getSession(), "mysql --host=192.168.101.144 --port=3306 -u kele01_db -p \"r.Wva-]p]ns+\" ");
        ssh.closeSSH();
    }
}