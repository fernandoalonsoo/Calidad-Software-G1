import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.*;

public class AddModifier  implements Serializable {

    private DatabaseManager databaseManager = new DatabaseManager();


    public Character AddModifier(Character c){
    Scanner scanner = new Scanner(System.in);
            System.out.println("Si quiere salir escriba 'salir':");
    String salir = scanner.nextLine();
            if(Objects.equals(salir, "salir")){
        return c;
    }
            System.out.print("Ingrese el nombre de la nueva modificación: ");
    String name = scanner.nextLine();
    int attack = 0;
    while (attack < 1 || attack > 5) {
        System.out.print("Ingrese el valor de la nueva modificación (entre 1 y 5): ");
        String aux = scanner.nextLine();
        try {
            attack = Integer.parseInt(aux);
            if ((attack < 1 || attack > 5)){
                System.out.println("Número no válido");
            }
        }catch (Exception e){
            System.out.println("Caracter no numeral");
        }
    }
    String buff;
    boolean b = false;
    boolean a = true;
    while(a) {
        System.out.print("Ingrese el tipo de modificación que desea (Debilidad o Fortaleza): ");
        buff = scanner.nextLine().toLowerCase();
        switch (buff) {
            case "debilidad" -> {
                b = false;
                a = false;
            }
            case "fortaleza" -> {
                b = true;
                a = false;
            }
            default -> System.out.println("Entrada no reconocida");
        }
    }

    Modifiers modifiers = new Modifiers();
            modifiers.setName(name);
            modifiers.setValue(attack);
            modifiers.setBuff(b);
            modifiers.setActive(false);
    List<Modifiers> modifiersList= c.getModifiersList();
            modifiersList.add(modifiers);
            c.setModifierList(modifiersList);
            System.out.println("Modificación añadida correctamente");

            return c;
}


    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }


    }




