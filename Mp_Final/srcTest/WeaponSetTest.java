import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeaponSetTest {

    @Test
    void weaponSet() {

            DatabaseManager databaseManager = new DatabaseManager();
            Map<String, Character> databaseC = new HashMap<>();
            Character character = new Character();
            Weapon weapon = new Weapon();
            WeaponSet weaponSet = new WeaponSet();
            List<Weapon> setdearmas = new ArrayList<>(1);

            weapon.setHands(1);
            weapon.setActive(false);
            weapon.setDefence(0);
            weapon.setAttack(1);
            weapon.setName("The Throngler");
            setdearmas.add(weapon);
            character.setWeaponSet(setdearmas);

            String[] entradas = {"1","1","Malmortius"};
            String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();

            InputStream in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals("Malmortius" , character.getWeaponSet().get(0).getName() );

            String[] entradas2 = {"1","2","3"};
            ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();

            in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals(3 , character.getWeaponSet().get(0).getAttack() );

            String[] entradas3 = {"1","3","2"};
            ch = String.join(System.lineSeparator(), entradas3) + System.lineSeparator();

            in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals(2 , character.getWeaponSet().get(0).getDefence() );

            String[] entradas4 = {"1","4","2"};
            ch = String.join(System.lineSeparator(), entradas4) + System.lineSeparator();

            in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals(2 , character.getWeaponSet().get(0).getHands() );

            String[] entradas5 = {"1","2","4","e","3"};
            ch = String.join(System.lineSeparator(), entradas5) + System.lineSeparator();

            in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals(3 , character.getWeaponSet().get(0).getAttack() );

            String[] entradas6 = {"1","3","4","e","1"};
            ch = String.join(System.lineSeparator(), entradas6) + System.lineSeparator();

            in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals(1 , character.getWeaponSet().get(0).getDefence() );

            String[] entradas7 = {"1","4","4","e","2"};
            ch = String.join(System.lineSeparator(), entradas7) + System.lineSeparator();

            in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals(2 , character.getWeaponSet().get(0).getHands() );

            String[] entradas8 = {"1","5","e","3","1"};
            ch = String.join(System.lineSeparator(), entradas8) + System.lineSeparator();

            in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals(1 , character.getWeaponSet().get(0).getDefence() );

            String[] entradas9 = {"1","3","-1", "3"};
            ch = String.join(System.lineSeparator(), entradas9) + System.lineSeparator();

            in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals(3 , character.getWeaponSet().get(0).getDefence() );

            String[] entradas10 = {"1","4","0","1"};
            ch = String.join(System.lineSeparator(), entradas10) + System.lineSeparator();

            in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals(1 , character.getWeaponSet().get(0).getHands() );

            String[] entradas11 = {"0","1"};
            ch = String.join(System.lineSeparator(), entradas11) + System.lineSeparator();

            in = new ByteArrayInputStream(ch.getBytes());
            System.setIn(in);

            character = weaponSet.WeaponSet(character);

            assertEquals("Malmortius" , character.getWeaponSet().get(0).getName() );




    }

}