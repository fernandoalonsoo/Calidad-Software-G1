import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GoldValueTest {

    @Test
    void goldValue() {
        GoldValue goldValue = new GoldValue();
        Character character = new Character();
        String ch = "15\n";
        character.setGoldValue(5);
        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        Character nuevoper = goldValue.GoldValue(character);
        assertEquals(15, nuevoper.getGoldValue());

        ch = "salir\n";
        character.setGoldValue(45);
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        nuevoper = goldValue.GoldValue(character);
        assertEquals(45, nuevoper.getGoldValue());
    }
}