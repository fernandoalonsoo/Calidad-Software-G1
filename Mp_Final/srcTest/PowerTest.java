import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PowerTest {

    @Test
    void power() {
        Power power = new Power();
        Character character = new Character();
        String ch = "a\n \n15\n \n3\n";
        character.setPower(5);
        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        Character nuevoper = power.Power(character);
        assertEquals(3, nuevoper.getPower());

        ch = "salir\n";
        character.setPower(5);
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        nuevoper = power.Power(character);
        assertEquals(5, nuevoper.getPower());
    }
}