import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EquipmentMenuTest {

    @Test
    void equipmentMenu() {
        DatabaseManager databaseManager = new DatabaseManager();
        Map<String, Character> databaseC = new HashMap<>();
        Map<String, User> databaseU = new HashMap<>();
        databaseC =  databaseManager.obtainDatabaseC();
        Character character = new Character();
        List<Weapon> listaa = new ArrayList<>();
        List<Armor> listaw = new ArrayList<>();
        EquipmentMenu equipmentMenu = new EquipmentMenu();

        character.setName("Bof");
        databaseU = databaseManager.obtainDatabaseU();


        User user = new User();
        user.setRegisterNumber("COCO");
        user.setName("Nabucodonosor");

        Weapon weapon = new Weapon();
        weapon.setHands(2);
        weapon.setAttack(2);
        weapon.setDefence(2);
        weapon.setName("adasdasdasdasdasdasdasdasd");
        weapon.setActive(false);

        Armor armor = new Armor();
        armor.setAttack(2);
        armor.setName("awasda");
        armor.setDefense(3);
        armor.setActive(false);
        listaa.add(weapon);
        listaw.add(armor);


        character.setWeaponSet(listaa);
        character.setArmorSet(listaw);

        databaseC.put(user.getRegisterNumber(), character);
        databaseU.put(user.getName(), user);
        databaseManager.saveDatabaseU(databaseU);
        databaseManager.saveDatabaseC(databaseC);


        String[] entradas = {"1", "1"};
        String ch = String.join(System.lineSeparator(), entradas) + System.lineSeparator();



        InputStream in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        equipmentMenu.EquipmentMenu( user, true );
        databaseC = databaseManager.obtainDatabaseC();
        Character aux =  databaseC.get(user.getRegisterNumber());

        assertTrue(aux.getWeaponSet().get(0).isActive());
        assertTrue(aux.getArmorSet().get(0).isActive());

        String[] entradas2 = {"2", "w ","1","2", " ","1"};
        ch = String.join(System.lineSeparator(), entradas2) + System.lineSeparator();
        in = new ByteArrayInputStream(ch.getBytes());
        System.setIn(in);

        equipmentMenu.EquipmentMenu( user, true );

        databaseC = databaseManager.obtainDatabaseC();
        aux =  databaseC.get(user.getRegisterNumber());



        assertTrue(aux.getWeaponSet().get(0).isActive());
        assertTrue(aux.getArmorSet().get(0).isActive());

    }
}