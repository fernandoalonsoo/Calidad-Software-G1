import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DescriptionTest {

    @Test
    void description() {
        Description description = new Description();
        Character character = new Character();
        String[] entradas = {"Ahora es oro 3"};
        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        character.setDescription("Es un platita");
        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        Character nuevoper = description.Description(character);


        assertEquals("Ahora es oro 3", nuevoper.getDescription());

        ch = "salir\n";
        nuevoper.setDescription("Que locura de pibe");
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        assertEquals("Que locura de pibe", nuevoper.getDescription());





    }
}