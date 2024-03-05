import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddModifierTest {

    @Test
    void addModifier() {
        AddModifier addModifier = new AddModifier();
        Character character = new Character();
        List<Modifiers> modifiersList = new ArrayList<>();
        character.setModifierList(modifiersList);

        String[] entradas = {"a","TestMod","a","6","5","a","debilidad"};
        String input = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Character newCharacter = addModifier.AddModifier(character);
        assertEquals(1, newCharacter.getModifiersList().size());
        assertEquals("TestMod", newCharacter.getModifiersList().get(0).getName());
        assertEquals(5, newCharacter.getModifiersList().get(0).getValue());
        assertFalse(newCharacter.getModifiersList().get(0).isBuff());
        assertFalse(newCharacter.getModifiersList().get(0).isActive());

        in = new ByteArrayInputStream("salir".getBytes());
        System.setIn(in);

        newCharacter = addModifier.AddModifier(character);
        assertEquals(1, newCharacter.getModifiersList().size());

        String[] entradas2 = {"a","TestMod","0","1","Fortaleza"};
        input = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        newCharacter = addModifier.AddModifier(character);
        assertEquals(2, newCharacter.getModifiersList().size());
        assertEquals("TestMod", newCharacter.getModifiersList().get(1).getName());
        assertEquals(1, newCharacter.getModifiersList().get(1).getValue());
        assertTrue(newCharacter.getModifiersList().get(1).isBuff());
        assertFalse(newCharacter.getModifiersList().get(1).isActive());
    }
}