import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseManagerTest {

    @Test
    void saveDatabaseC() {
        DatabaseManager databaseManager = new DatabaseManager();
        Map<String,Character> databaseC = databaseManager.obtainDatabaseC();
        Map<String,Character> aux = databaseManager.obtainDatabaseC();
        Character character = new Character();

        databaseC.put("aaa",character);
        databaseManager.saveDatabaseC(databaseC);

        databaseC = databaseManager.obtainDatabaseC();
        assertEquals(aux.size()+1,databaseC.size());

        databaseC.remove("aaa");
        databaseManager.saveDatabaseC(databaseC);

        databaseC = databaseManager.obtainDatabaseC();
        assertEquals(aux.size(),databaseC.size());

    }

    @Test
    void saveDatabaseH() {
        DatabaseManager databaseManager = new DatabaseManager();
        Map<String,History> databaseH = databaseManager.obtainDatabaseH();
        Map<String,History> aux = databaseManager.obtainDatabaseH();
        History history = new History();

        databaseH.put("aaa",history);
        databaseManager.saveDatabaseH(databaseH);

        databaseH = databaseManager.obtainDatabaseH();
        assertEquals(aux.size()+1,databaseH.size());

        databaseH.remove("aaa");
        databaseManager.saveDatabaseH(databaseH);

        databaseH = databaseManager.obtainDatabaseH();
        assertEquals(aux.size(),databaseH.size());
    }

    @Test
    void saveDatabaseU() {
        DatabaseManager databaseManager = new DatabaseManager();
        Map<String,User> databaseU = databaseManager.obtainDatabaseU();
        Map<String,User> aux = databaseManager.obtainDatabaseU();
        User user = new User();

        databaseU.put("aaa",user);
        databaseManager.saveDatabaseU(databaseU);

        databaseU = databaseManager.obtainDatabaseU();
        assertEquals(aux.size()+1,databaseU.size());

        databaseU.remove("aaa");
        databaseManager.saveDatabaseU(databaseU);

        databaseU = databaseManager.obtainDatabaseU();
        assertEquals(aux.size(),databaseU.size());
    }

    @Test
    void saveDatabaseP() {
        DatabaseManager databaseManager = new DatabaseManager();
        Map<String, List<Challenge>> databaseP = databaseManager.obtainDatabaseP();
        Map<String,List<Challenge>> aux = databaseManager.obtainDatabaseP();
        List<Challenge> challenges = new ArrayList<>();

        databaseP.put("aaa",challenges);
        databaseManager.saveDatabaseP(databaseP);

        databaseP = databaseManager.obtainDatabaseP();
        assertEquals(aux.size()+1,databaseP.size());

        databaseP.remove("aaa");
        databaseManager.saveDatabaseP(databaseP);

        databaseP = databaseManager.obtainDatabaseP();
        assertEquals(aux.size(),databaseP.size());
    }
}