import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddMinionTest {

    @Test
    public void AddMinion() {
            List<Minion> minionList = new ArrayList<>();
            AddMinion addMinion = new AddMinion();

            // Test adding a human minion
            String[] inputs = {"a","Jhon","0","4","3", "Humano"};
            System.setIn(new java.io.ByteArrayInputStream(String.join(System.lineSeparator(), inputs).getBytes()));
            minionList = addMinion.AddMinion(minionList);
            assertEquals(1, minionList.size());
            assertEquals("Jhon", minionList.get(0).getName());
            assertEquals(3, minionList.get(0).getHitPoints());
            assertEquals(TMinion.HUMAN, minionList.get(0).getTipominion());

            // Test adding a ghoul minion
            inputs = new String[]{"a","Ghoul", "3", "Ghoul"};
            System.setIn(new java.io.ByteArrayInputStream(String.join(System.lineSeparator(), inputs).getBytes()));
            minionList = addMinion.AddMinion(minionList);
            assertEquals(2, minionList.size());
            assertEquals("Ghoul", minionList.get(1).getName());
            assertEquals(3, minionList.get(1).getHitPoints());
            assertEquals(TMinion.GHOUL, minionList.get(1).getTipominion());

        // Test adding a demon minion, no hay que comprobar añadirle otro minion porque es recursivo
            inputs = new String[]{"a","Demon", "1", "Demonio", "pacto", "a"};
            System.setIn(new java.io.ByteArrayInputStream(String.join(System.lineSeparator(), inputs).getBytes()));
            minionList = addMinion.AddMinion(minionList);
            assertEquals(3, minionList.size());
            assertEquals("Demon", minionList.get(2).getName());
            assertEquals(1, minionList.get(2).getHitPoints());
            assertEquals(TMinion.DEMON, minionList.get(2).getTipominion());
            assertEquals("pacto", ((Demon)minionList.get(2)).getPact());
            assertEquals(0, ((Demon)minionList.get(2)).getMinionList().size());
        }
    }