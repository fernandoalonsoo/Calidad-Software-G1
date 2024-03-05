import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DeleteAdminTest {

    @Test
    void deleteAdmin() {
        DatabaseManager databaseManager =new DatabaseManager();
        Map<String, User> databaseU = new HashMap<>();
        Map<String, User> databaseUaux = new HashMap<>();
        User user = new User();
        user.setName("¬adsl");
        user.setPassword("12345678");
        DeleteAdmin deleteAdmin = new DeleteAdmin();

        String[] entradas = {"¬adsl", "12345678", "2"};
        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        User u = deleteAdmin.DeleteAdmin(user);
        assertEquals(u, user);

        String[] entradas2 = {"¬adsl", "12345678", "1", "N"};
        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        u = deleteAdmin.DeleteAdmin(user);
        assertEquals(u, user);

        String[] entradas3 = {"¬adsl", "12345678",  "1", "S"};
        ch = String.join(System.lineSeparator(), entradas3) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        databaseU = databaseManager.obtainDatabaseU();
        databaseUaux = databaseManager.obtainDatabaseU();
        databaseU.put(user.getName(), user);
        databaseU = databaseManager.obtainDatabaseU();
        databaseManager.saveDatabaseU(databaseU);

        u = deleteAdmin.DeleteAdmin(user);
        databaseU = databaseManager.obtainDatabaseU();
        assertNull(u);
        assertEquals(databaseUaux.size(),databaseU.size());

    }
}