import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MinionMapTest {

    @Test
    void minionMap() {
        Character character = new Character();

        Minion minion = new Minion();
        MinionMap minionMap = new MinionMap();

        minion.setName("hola");
        minion.setHitPoints(2);
        minion.setTipominion(TMinion.HUMAN);
        character.getMinionMap().add(minion);
        String[] entradas1 = {"0"};

        String ch = String.join(System.lineSeparator(), entradas1) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character = minionMap.MinionMap(character);

        assertEquals(character.getMinionMap().get(0).getName(),"hola");


        String[] entradas = {"a","2","-1","1","a","0","4","1","Exhaust"};
        ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();

        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);


        character = minionMap.MinionMap(character);
        assertEquals("Exhaust" , character.getMinionMap().get(0).getName() );




        String[] entradas2 = {"1","2","4","0","3"};

        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();


        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character = minionMap.MinionMap(character);

        assertEquals(3 , character.getMinionMap().get(0).getHitPoints() );

        String[] entradas3 = {"1","3","-1","e","humano" };

        ch = String.join(System.lineSeparator(), entradas3) + System.lineSeparator();


        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character = minionMap.MinionMap(character);

        assertEquals(TMinion.HUMAN , character.getMinionMap().get(0).getTipominion() );

        String[] entradas4 = {"1","3","ghoul" };
        ch = String.join(System.lineSeparator(), entradas4) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character = minionMap.MinionMap(character);

        assertEquals(TMinion.GHOUL , character.getMinionMap().get(0).getTipominion() );
        // no compruebo meter otro minion porque es AddMinion
        String[] entradas5 = {"1","3","demonio", "a", "a"};
        ch = String.join(System.lineSeparator(), entradas5) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        character = minionMap.MinionMap(character);
        Demon demon = (Demon) character.getMinionMap().get(0);
        assertEquals(TMinion.DEMON , character.getMinionMap().get(0).getTipominion() );
        assertEquals("a" , demon.getPact());

    }
}