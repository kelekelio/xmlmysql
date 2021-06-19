package CMD;

import Util.DumpDb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CmdTest {



    @Test
    void backupdbtosql() {
        DumpDb.execute("26158902_db_0106a", "26158902_db");
    }

    @Test
    void beckupAionnHerokuDb(){
        DumpDb.execute("aion_1206", "aion");
    }

    @Test
    void db_to_zip() {
    }
}