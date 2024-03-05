import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class SpecialAbilityTest {

    @Test
    void specialAbility() {
        Character character = new Character();
        SpecialAbility specialAbility = new SpecialAbility();

        Ability ability = new Ability();

        ability.setDefense(3);
        ability.setAttack(3);
        character.setSpecialAbility(ability);


        String[] entradas = {"1","2"};
        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();



        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        Character characteraux = specialAbility.SpecialAbility(character);

        assertEquals(2, characteraux.getSpecialAbility().getAttack() );


        String[] entradas1 = {"2","2"};
         ch = String.join(System.lineSeparator(), entradas1) + System.lineSeparator();


        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        characteraux = specialAbility.SpecialAbility(character);

        assertEquals(2, characteraux.getSpecialAbility().getDefense() );

        String[] entradas2 = {"3","1","4","1" };
        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);


        characteraux = specialAbility.SpecialAbility(character);
        assertEquals(1, characteraux.getSpecialAbility().getAttack() );

    }
}