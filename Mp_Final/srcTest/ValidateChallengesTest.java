import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class ValidateChallengesTest {

    @Test
    public void testValidateChallenges() {

        DatabaseManager databaseManager = new DatabaseManager();
        Map<String, List<Challenge>> databaseP = databaseManager.obtainDatabaseP();
        Map<String, Character> databaseC = databaseManager.obtainDatabaseC();
        Modifiers modifiers = new Modifiers();
        Character character = new Character();
        Character character1 = new Character();
        databaseC = databaseManager.obtainDatabaseC();


        List<Modifiers> modifierList = new ArrayList<>();
        modifiers.setActive(false);
        modifiers.setBuff(true);
        modifiers.setName("Manolo");
        modifiers.setValue(2);
        Modifiers modifiers2 = new Modifiers();

        List<Modifiers> modifierList2 = new ArrayList<>();

        modifiers2.setActive(false);
        modifierList.add(modifiers2);
        modifierList2.add(modifiers);;



        User user1 = new User();
        user1.setName("Julio");
        user1.setRegisterNumber("CABROI");
        User user2 = new User();
        user2.setName("Jane-Doe");
        user2.setRegisterNumber("CABROI2");


        character.setModifierList(modifierList);
        character1.setModifierList(modifierList2);

        databaseC.put(user1.getRegisterNumber(),character1);
        databaseC.put(user2.getRegisterNumber(),character);

        databaseManager.saveDatabaseC(databaseC);







        // Create a challenge for user1
        Challenge challenge1 = new Challenge();
        challenge1.setGold(100);
        challenge1.setDefied(user1);
        challenge1.setDefiant(user2);

        // Create a challenge for user2
        Challenge challenge2 = new Challenge();
        challenge2.setDefied(user1);
        challenge2.setDefiant(user2);
        challenge2.setGold(5);

        List<Challenge> challengelist = new ArrayList<>();
        challengelist.add(challenge1);
        challengelist.add(challenge2);

        String[] entradas = {"1", user1.getRegisterNumber(),"1", "2"};

        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();

        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);


        databaseP.put(user1.getRegisterNumber(), challengelist);

        databaseManager.saveDatabaseP(databaseP);
        // Validate the challenges
        User aux = new User();
        ValidateChallenges validator = new ValidateChallenges();


        validator.ValidateChallenges(aux);

        Map<String, List<Challenge>> aux2 = databaseManager.obtainDatabaseP();


        // Assert that the challenges are now validated
        assertEquals(aux2.get(user1.getRegisterNumber()).size(),challengelist.size()-1);

        String[] entradas2 = {user1.getRegisterNumber(),"0", "1","0","salir","salir"};

        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();

        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        User aux3 = new User();


        validator.ValidateChallenges(aux3);
        aux2 = databaseManager.obtainDatabaseP();


        Map<String,Character> auxC = databaseManager.obtainDatabaseC();

        // Assert that the challenges are now validated
        assertTrue(aux2.get(user1.getRegisterNumber()).get(0).isValid());
        assertTrue(auxC.get(user1.getRegisterNumber()).getModifiersList().get(0).isActive());
        assertFalse(auxC.get(user2.getRegisterNumber()).getModifiersList().get(0).isActive());
    }
}
