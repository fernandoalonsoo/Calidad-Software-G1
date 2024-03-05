import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class HitPointsTest {

    @Test
    void hitPoints() {
        HitPoints hitPoints = new HitPoints();
        Character character = new Character();
        String ch = "15\n10\n";
        character.sethP(5);
        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        Character nuevoper = hitPoints.HitPoints(character);
        assertEquals(10, nuevoper.gethP());

        ch = "salir\n";
        character.sethP(5);
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        nuevoper = hitPoints.HitPoints(character);
        assertEquals(5, nuevoper.gethP());
    }
}