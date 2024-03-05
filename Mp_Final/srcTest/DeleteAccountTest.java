import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DeleteAccountTest {


    @Test
    void deleteAccount() {


         DatabaseManager databaseManager =new DatabaseManager();
         Map<String, User> databaseU = new HashMap<>();
         Map<String, User> databaseUaux = new HashMap<>();
         User user = new User();
         user.setName("AAAA");
         DeleteAccount deleteAccount = new DeleteAccount();
         String[] entradas = {"N"};
         String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
         InputStream in = new ByteArrayInputStream(ch.getBytes());
         System.setIn(in);

         databaseUaux = databaseManager.obtainDatabaseU();
         databaseU = databaseManager.obtainDatabaseU();
         databaseU.put(user.getName(), user);
         databaseManager.saveDatabaseU(databaseU);

         User useraux = deleteAccount.DeleteAccount(user);
         assertEquals(user,useraux);

         String[] entradas2 = {"S", "a"};
         ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
         in = new ByteArrayInputStream(ch.getBytes());
         System.setIn(in);

         user = deleteAccount.DeleteAccount(user);
         databaseU = databaseManager.obtainDatabaseU();
         assertNull(user);
         assertEquals(databaseUaux.size(), databaseU.size());

    }
}