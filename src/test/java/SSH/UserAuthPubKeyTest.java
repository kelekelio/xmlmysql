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
        ssh.executeSSH(ssh.getSession(), "");
        ssh.closeSSH();
    }
}