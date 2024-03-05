import java.io.Serializable;
import java.util.*;

public class AddWeapon  implements Serializable {
    private DatabaseManager databaseManager = new DatabaseManager();

    public Character AddWeapon(Character c){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Si quiere salir escriba 'salir':");
            String salir = scanner.nextLine();
            if(Objects.equals(salir, "salir")){
                return c;
            }
            System.out.print("Ingrese el nombre del nuevo arma: ");
                String name = scanner.nextLine();
            int attack = 0;
            while (attack < 1 || attack > 3) {
                System.out.print("Ingrese el ataque del nuevo arma (entre 1 y 3): ");
                String aux = scanner.nextLine();
                try {
                    attack = Integer.parseInt(aux);
                    if (attack < 1 || attack > 3){
                        System.out.println("Número no válido");
                    }
                }catch (Exception e){
                    System.out.println("Caracter no numeral");
                }
            }
            int defense = -1;
            while (defense < 0 || defense > 3) {
                System.out.print("Ingrese la defensa del nuevo arma (entre 0 y 3): ");
                String aux1 = scanner.nextLine();
                try {
                    defense = Integer.parseInt(aux1);
                    if (defense < 0 || defense > 3) {
                        System.out.println("Número no valido");
                    }
                }catch (Exception e){
                    System.out.println("Caracter no numeral");
                }
            }
            int hands = 0;
            while (hands < 1 || hands > 2) {
                System.out.print("Ingrese las manos del nuevo arma (entre 1 y 2): ");
                String aux2 = scanner.nextLine();
                try {
                    hands = Integer.parseInt(aux2);
                    if (hands < 1 || hands > 2) {
                        System.out.println("Número no válido");
                    }

                }catch (Exception e){
                    System.out.println("Caracter no numeral");
                }
            }
            Weapon newWeapon = new Weapon();
            newWeapon.setName(name);
            newWeapon.setAttack(attack);
            newWeapon.setDefence(defense);
            newWeapon.setHands(hands);
            newWeapon.setActive(false);
            List<Weapon> weaponList= c.getWeaponSet();
            weaponList.add(newWeapon);
            c.setWeaponSet(weaponList);
            System.out.print("Arma añadida correctamente");

            return c;
    }


    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

}
