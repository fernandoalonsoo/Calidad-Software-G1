import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class FighterTest {

    @Test
    void fighter() {
        NewCharacter newCh = new NewCharacter();
        String[] entradas = {"Jose", "Es muy listo", "1"};
        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        Character c = newCh.NewCharacter();
        Fighter fighter = new Fighter();

        fighter.setName(c.getName());
        fighter.setType(c.getType());
        fighter.setDescription(c.getDescription());
        fighter.sethP(c.gethP());
        fighter.setWeaponSet(c.getWeaponSet());
        fighter.setArmorSet(c.getArmorSet());
        fighter.setPower(c.getPower());
        fighter.setMinionMap(c.getMinionMap());
        fighter.setModifierList(c.getModifiersList());
        fighter.setSpecialAbility(c.getSpecialAbility());
        fighter.setWins(c.getWins());
        fighter.setGoldValue(c.getGoldValue());
        fighter.setFighting(true);
        fighter.setFighterHP(fighter.gethP());
        int attckP = fighter.getPower() + fighter.getSpecialAbility().getAttack() + fighter.getTypeAttack();
        int defP = fighter.getPower() + fighter.getSpecialAbility().getDefense() + fighter.getTypeAttack();

        fighter.Fighter(fighter);
        assertEquals(defP,fighter.getDefensePower());
        assertEquals(attckP,fighter.getAttackPower());

        String[] entradas2 = {"Jose", "Es muy listo", "2"};
        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        fighter.setName(c.getName());
        fighter.setType(c.getType());
        fighter.setDescription(c.getDescription());
        fighter.sethP(c.gethP());
        fighter.setWeaponSet(c.getWeaponSet());
        fighter.setArmorSet(c.getArmorSet());
        fighter.setPower(c.getPower());
        fighter.setMinionMap(c.getMinionMap());
        fighter.setModifierList(c.getModifiersList());
        fighter.setSpecialAbility(c.getSpecialAbility());
        fighter.setWins(c.getWins());
        fighter.setGoldValue(c.getGoldValue());
        fighter.setFighting(true);
        fighter.setFighterHP(fighter.gethP());
        attckP = fighter.getPower() + fighter.getSpecialAbility().getAttack() + fighter.getTypeAttack();
        defP = fighter.getPower() + fighter.getSpecialAbility().getDefense() + fighter.getTypeAttack();

        if (fighter.getSpecialAbility().getSpecialValue() <= fighter.getTypeAttack()) {
            attckP += fighter.getSpecialAbility().getSpecialValue();
            defP += fighter.getSpecialAbility().getSpecialValue();
        }
        fighter.Fighter(fighter);
        assertEquals(defP,fighter.getDefensePower());
        assertEquals(attckP,fighter.getAttackPower());

        String[] entradas3 = {"Jose", "Es muy listo", "3"};
        ch = String.join(System.lineSeparator(), entradas3) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);
        c = newCh.NewCharacter();

        fighter.setType(c.getType());
        fighter.sethP(c.gethP());
        fighter.setWeaponSet(c.getWeaponSet());
        fighter.setArmorSet(c.getArmorSet());
        fighter.setPower(c.getPower());
        fighter.setMinionMap(c.getMinionMap());
        fighter.setModifierList(c.getModifiersList());
        fighter.setSpecialAbility(c.getSpecialAbility());
        fighter.setWins(c.getWins());
        fighter.setGoldValue(c.getGoldValue());
        fighter.setFighting(true);
        fighter.setFighterHP(fighter.gethP());
        attckP = fighter.getPower() + fighter.getSpecialAbility().getAttack();
        defP = fighter.getPower() + fighter.getSpecialAbility().getDefense();

        if (fighter.getTypeAttack() >= 5) {
            attckP += 2;
            defP += 2;
        }

        if (fighter.getSpecialAbility().getSpecialValue() <= fighter.getTypeAttack()) {
            attckP += fighter.getSpecialAbility().getSpecialValue();
            defP += fighter.getSpecialAbility().getSpecialValue();
        }
        fighter.Fighter(fighter);
        assertEquals(defP,fighter.getDefensePower());
        assertEquals(attckP,fighter.getAttackPower());

    }
}