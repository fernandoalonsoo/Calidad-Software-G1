import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TypeTest {

    @Test
    void type() {
    Type type = new Type();
    Character character = new Character();


    String[] entradas = {"Vampiro", " "};
    String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
    InputStream in = new ByteArrayInputStream(ch.getBytes());
    System.setIn(in);
    character.setType(TCharacter.WEREWOLF);
    type.Type(character);



    Assertions.assertEquals(TCharacter.VAMPIRE, character.getType());

        String[] entradas2 = {"Licántropo", " "};
         ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
         in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character.setType(TCharacter.VAMPIRE);
        type.Type(character);

        Assertions.assertEquals(TCharacter.WEREWOLF, character.getType());

        String[] entradas3 = {"Cazador", " "};
        ch = String.join(System.lineSeparator(), entradas3) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character.setType(TCharacter.WEREWOLF);
        type.Type(character);

        Assertions.assertEquals(TCharacter.HUNTER, character.getType());

















    }
}