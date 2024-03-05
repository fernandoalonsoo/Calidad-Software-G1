import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ArmorSetTest {

    @Test
    void armorSet() {

        DatabaseManager databaseManager = new DatabaseManager();
        Map<String, Character> databaseC = new HashMap<>();
        Character character = new Character();
        Armor armor  = new Armor();
        ArmorSet armorSet = new ArmorSet();
        List<Armor> setdearmadura = new ArrayList<>(1);



        armor.setActive(false);
        armor.setDefense(0);
        armor.setAttack(1);
        armor.setName("Minish Cap");
        setdearmadura.add(armor);
        character.setArmorSet(setdearmadura);

        String[] entradas = {"1","1","Coraza del hombre muerto"};
        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();

        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        character = armorSet.ArmorSet(character);

        assertEquals("Coraza del hombre muerto" , character.getArmorSet().get(0).getName() );



        String[] entradas2 = {"1","2","3"};
        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();

        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        character = armorSet.ArmorSet(character);

        assertEquals(3 , character.getArmorSet().get(0).getAttack() );

        String[] entradas3 = {"1","3","2"};
        ch = String.join(System.lineSeparator(), entradas3) + System.lineSeparator();

        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        character = armorSet.ArmorSet(character);

        assertEquals(2 , character.getArmorSet().get(0).getDefense() );

        String[] entradas4 = {"1","4","2"};
        ch = String.join(System.lineSeparator(), entradas4) + System.lineSeparator();



        String[] entradas5 = {"1","2","4","e","3"};
        ch = String.join(System.lineSeparator(), entradas5) + System.lineSeparator();

        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        character = armorSet.ArmorSet(character);

        assertEquals(3 , character.getArmorSet().get(0).getAttack() );


        String[] entradas6 = {"1","3","4","e","1"};
        ch = String.join(System.lineSeparator(), entradas6) + System.lineSeparator();

        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        character = armorSet.ArmorSet(character);


        assertEquals(1 , character.getArmorSet().get(0).getDefense() );

        String[] entradas7 = {"1","4","4","e","2"};
        ch = String.join(System.lineSeparator(), entradas7) + System.lineSeparator();



        String[] entradas8 = {"1","5","e","3","1"};
        ch = String.join(System.lineSeparator(), entradas8) + System.lineSeparator();

        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        character = armorSet.ArmorSet(character);

        assertEquals(1 , character.getArmorSet().get(0).getDefense() );

        String[] entradas9 = {"1","3","-1", "3"};
        ch = String.join(System.lineSeparator(), entradas9) + System.lineSeparator();

        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        character = armorSet.ArmorSet(character);

        assertEquals(3 , character.getArmorSet().get(0).getDefense() );

        String[] entradas10 = {"3", ""};
        ch = String.join(System.lineSeparator(), entradas10) + System.lineSeparator();

        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        character = armorSet.ArmorSet(character);

        assertEquals(3 , character.getArmorSet().get(0).getDefense() );


    }
}