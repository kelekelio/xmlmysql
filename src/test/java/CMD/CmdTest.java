package CMD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CmdTest {



    @Test
    void backupdbtosql() {
        Cmd.Backupdbtosql("1028a", "aion");
    }

    @Test
    void db_to_zip() {
    }
}