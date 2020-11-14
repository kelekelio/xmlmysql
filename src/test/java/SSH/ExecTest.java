package SSH;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grzegorz Nowakowski
 */
class ExecTest {

    @Test
    void testCommandExecution () {
        SSH.Exec.SshCommand("unzip -o public_html/java/aion_79.20.1109.zip -d public_html/java/");
        SSH.Exec.SshCommand("mysql --host=192.168.101.74 --port=3306 -u kele01_java2 -pr.Wva-]p]ns+ kele01_java < public_html/java/aion_79.20.1109.sql");

    }

}