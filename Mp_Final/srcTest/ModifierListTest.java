import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ModifierListTest {

    @Test
    void modifierList() {

        Character character = new Character();

        Modifiers modifiers = new Modifiers();
        ModifierList modifierList = new ModifierList();

        modifiers.setName("loocoooo");
        modifiers.setValue(2);
        modifiers.setBuff(true);
        modifiers.setActive(false);
        character.getModifiersList().add(modifiers);


        String[] entradas = {"1","1","Exhaust"};
        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();

        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);


        character = modifierList.ModifierList(character);


        assertEquals("Exhaust" , character.getModifiersList().get(0).getName() );


        String[] entradas1 = {"1","2"};

        ch = String.join(System.lineSeparator(), entradas1) + System.lineSeparator();


        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character = modifierList.ModifierList(character);

        assertFalse(character.getModifiersList().get(0).isBuff());

        String[] entradas2 = {"1","3", "4"};

        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();


        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character = modifierList.ModifierList(character);

        assertEquals(4 , character.getModifiersList().get(0).getValue() );

        String[] entradas3 = {"1","3", "-1", "6", "e" ,"5" };

        ch = String.join(System.lineSeparator(), entradas3) + System.lineSeparator();


        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character = modifierList.ModifierList(character);

        assertEquals(5 , character.getModifiersList().get(0).getValue() );

        String[] entradas4 = { "5", "3", "-1", "6", "e" ,"1", "1", "바보" };

        ch = String.join(System.lineSeparator(), entradas4) + System.lineSeparator();


        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character = modifierList.ModifierList(character);

        assertEquals( "바보" , character.getModifiersList().get(0).getName() );











    }
}