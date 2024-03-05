import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class AddArmorTest {

        @Test
        void addArmorTest() {
            AddArmor addArmor = new AddArmor();
            Character character = new Character();
            List<Armor> armorList = new ArrayList<>();
            character.setArmorSet(armorList);

            String[] entradas = {"a","TestArmor","a","4","3","a","4","3"};
            String input = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            Character newCharacter = addArmor.AddArmor(character);
            assertEquals(1, newCharacter.getArmorSet().size());
            assertEquals("TestArmor", newCharacter.getArmorSet().get(0).getName());
            assertEquals(3, newCharacter.getArmorSet().get(0).getAttack());
            assertEquals(3, newCharacter.getArmorSet().get(0).getDefense());
            assertFalse(newCharacter.getArmorSet().get(0).isActive());

            in = new ByteArrayInputStream("salir".getBytes());
            System.setIn(in);

            newCharacter = addArmor.AddArmor(character);
            assertEquals(1, newCharacter.getArmorSet().size());

            String[] entradas2 = {"a","TestArmor","-1","0","0","1"};
            input = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            newCharacter = addArmor.AddArmor(character);
            assertEquals(2, newCharacter.getArmorSet().size());
            assertEquals("TestArmor", newCharacter.getArmorSet().get(1).getName());
            assertEquals(0, newCharacter.getArmorSet().get(1).getAttack());
            assertEquals(1, newCharacter.getArmorSet().get(1).getDefense());
            assertFalse(newCharacter.getArmorSet().get(1).isActive());
        }
    }

