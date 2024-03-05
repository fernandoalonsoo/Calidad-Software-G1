import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCharacterTest {

    @Test
    void deleteCharacter() {
        DeleteCharacter   deleteCharacter = new DeleteCharacter();
        DatabaseManager databaseManager = new DatabaseManager();
        Map<String,Character> databaseC = databaseManager.obtainDatabaseC();
        Map<String,Character> aux = databaseManager.obtainDatabaseC();
        User user = new User();
        Character character = new Character();
        character.setName("quetzatcoatl");
        user.setRegisterNumber("AAAAA");
        databaseC.put(user.getRegisterNumber(),character);
        databaseManager.saveDatabaseC(databaseC);

        String[] entradas = {"e"};
        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        Character c = deleteCharacter.deleteCharacter(user);
        databaseC = databaseManager.obtainDatabaseC();
        assertEquals(c.getName(),character.getName());
        assertEquals(aux.size()+1,databaseC.size());

        String[] entradas2 = {"1"};
        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        databaseC = databaseManager.obtainDatabaseC();
        databaseC.put(user.getRegisterNumber(),character);
        databaseManager.saveDatabaseC(databaseC);
        c = deleteCharacter.deleteCharacter(user);
        databaseC = databaseManager.obtainDatabaseC();
        assertNull(c);
        assertEquals(aux.size(),databaseC.size());
    }
    @Test
    void deleteCharacter2(){
        DeleteCharacter   deleteCharacter = new DeleteCharacter();
        DatabaseManager databaseManager = new DatabaseManager();
        Map<String,Character> databaseC = databaseManager.obtainDatabaseC();
        Map<String,Character> aux = databaseManager.obtainDatabaseC();
        User user = new User();
        Character character = new Character();
        user.setRegisterNumber("AAAAA");
        databaseC.put(user.getRegisterNumber(),character);
        databaseManager.saveDatabaseC(databaseC);
        deleteCharacter.deleteCharacter2(user);
        databaseC = databaseManager.obtainDatabaseC();
        assertEquals(aux.size(),databaseC.size());
    }
}