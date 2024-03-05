import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbilityTest {
    
    @Test
    void setType() {
        Ability ability = new Ability();
        ability.setType(TCharacter.HUNTER);
        assertEquals(TAbility.TALENT,ability.getType());
        assertEquals(0,ability.getSpecialValue());

        ability.setType(TCharacter.VAMPIRE);
        assertEquals(TAbility.DISCIPLINE,ability.getType());

        ability.setType(TCharacter.WEREWOLF);
        assertEquals(TAbility.GIFT,ability.getType());
    }
}