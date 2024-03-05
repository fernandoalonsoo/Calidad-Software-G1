import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void setType() {
        Character character = new Character();
        character.setType("Vampiro");
        assertEquals(TCharacter.VAMPIRE,character.getType());

        character.setType("Cazador");
        assertEquals(TCharacter.HUNTER,character.getType());

        character.setType("Licántropo");
        assertEquals(TCharacter.WEREWOLF,character.getType());
    }
}