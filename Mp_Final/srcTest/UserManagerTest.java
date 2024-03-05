import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Test
    void userManager() {
        DatabaseManager databaseManager = new DatabaseManager();
        Map<String, User> databaseU = new HashMap<>();
        UserManager userManager = new UserManager();
        User user = new User();


        user.setBanned(false);
        user.setName("Atahualpa");
        user.setRegisterNumber("AAAA");
        databaseU = databaseManager.obtainDatabaseU();
        databaseU.put(user.getName(), user);
        databaseManager.saveDatabaseU(databaseU);


        String[] entradas = {"1","2", "Atahualpa" ,"4"};
        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();



        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        userManager.UserManager();


        Assertions.assertEquals(true, databaseManager.obtainDatabaseU().get(user.getName()).isBanned());


        databaseManager.obtainDatabaseU().get(user.getName()).setBanned(true);
        databaseManager.obtainDatabaseU().get(user.getName()).isBanned();
        String[] entradas2 = {"2", "Atahualpa" ,"4"};
        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        userManager.UserManager();






    }
}