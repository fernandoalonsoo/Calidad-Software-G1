import java.io.Serializable;
import java.util.*;

public class AddArmor implements Serializable {
    private DatabaseManager databaseManager = new DatabaseManager();

    public Character AddArmor(Character c){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Si quiere salir escriba 'salir':");
        String salir = scanner.nextLine();
        if(Objects.equals(salir, "salir")){
            return c;
        }
        System.out.print("Ingrese el nombre de la nueva armadura: ");
        String name = scanner.nextLine();
        int attack = -1;
        while (attack < 0 || attack > 3) {
            System.out.print("Ingrese el ataque de la nueva armadura (entre 0 y 3): ");
            String aux1 = scanner.nextLine();
            try {
                attack = Integer.parseInt(aux1);
                if (attack < 0 || attack > 3){
                    System.out.println("Número no válido");
                }
            }catch (Exception e){
                System.out.println("Caracter no numeral");
            }
        }

        int defense = 0;
        do{
            System.out.print("Ingrese la defensa de la nueva armadura (entre 1 y 3): ");
            String aux = scanner.nextLine();
            try {
                defense = Integer.parseInt(aux);
                if (defense < 0 || defense > 3){
                    System.out.println("Número no válido");
                }
            }catch (Exception e){
                System.out.println("Caractér no numeral");
            }
        }while (defense < 1 || defense > 3);
            Armor newArmor = new Armor();
        newArmor.setName(name);
        newArmor.setAttack(attack);
        newArmor.setDefense(defense);
        newArmor.setActive(false);
        List<Armor> armorList= c.getArmorSet();
        armorList.add(newArmor);
        c.setArmorSet(armorList);


        System.out.print("Armadura añadida correctamente");
        return c;

    }


    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

}
