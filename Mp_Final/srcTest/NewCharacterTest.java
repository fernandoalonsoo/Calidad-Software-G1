import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class NewCharacterTest {

    @Test
    void newCharacter() {
        NewCharacter newCharacter = new NewCharacter();
        String[] entradas = {"Jose","Es muy listo","1"};
        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        Character asd =  newCharacter.NewCharacter();


        Assertions.assertEquals("Jose", asd.getName());
        Assertions.assertEquals(TCharacter.HUNTER,asd.getType());
        Assertions.assertEquals("Es muy listo",asd.getDescription());

        String []    entradas2 = {"Jose","Es muy listo","2"};
        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        asd =  newCharacter.NewCharacter();
        Assertions.assertEquals(TCharacter.WEREWOLF,asd.getType());

        String []   entradas3 = {"Jose","Es muy listo","3"};
        ch = String.join(System.lineSeparator(), entradas3) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        asd =  newCharacter.NewCharacter();
        Assertions.assertEquals(TCharacter.VAMPIRE,asd.getType());








    }
}