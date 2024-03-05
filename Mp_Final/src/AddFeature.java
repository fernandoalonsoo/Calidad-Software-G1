import java.io.Serializable;
import java.util.*;

public class AddFeature  implements Serializable {

    private DatabaseManager databaseManager = new DatabaseManager();
    private Map<String, Character> databaseC = new HashMap<>();
    private Map<String,List<Minion>> databaseM = new HashMap<>();
    private Map<String,User> databaseU = new HashMap<>();


    public void AddFeature(User u){
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    databaseC = databaseManager.obtainDatabaseC();
    databaseU = databaseManager.obtainDatabaseU();
    System.out.println("\n[-------------------------------------]");
    System.out.println("             AÑADIR CARACTERÍSTICA");
    System.out.println("[-------------------------------------]\n");
    System.out.println("     [---------------- LISTA DE USUARIOS -------------] ");
    Set<String> keyset = databaseU.keySet();

        for (String key : keyset) {
            User user = databaseU.get(key);
            if (user != null) {
                if (!user.getName().startsWith("¬")){
                    System.out.println("                 >Usuario: " + user.getName());
                    System.out.println("                 >Numero de registro: " + user.getRegisterNumber());
                    System.out.println("     ------------------------------------------------- ");
                }
            }
        }
    System.out.println();
    String player;
    do {
        System.out.print("Ingrese el numero de registro del jugador a editar:");
        player = scanner.nextLine();
        if (player.equalsIgnoreCase("salir")) {
            menuAdmin(u);
        }else if(databaseC.get(player) == null) {
            System.out.println("El jugador no tiene personajes.");
            player = scanner.nextLine();
        }
    }while (databaseC.get(player) == null);

    String option ;
    while(!exit){
        Character c = databaseC.get(player);
        System.out.println("1. Agregar modificador");
        System.out.println("2. Agregar arma");
        System.out.println("3. Agregar armadura");
        System.out.println("4. Agregar minions");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opción:");
        option = scanner.nextLine();


        switch (option) {
            case "1" -> c = addModifier(c);
            case "2" -> c = addWeapon(c);
            case "3" -> c = addArmor(c);
            case "4" -> c = addMinions(c);
            case "5" -> exit = true;
            default -> System.out.println("Opción inválida. Intente de nuevo.");
        }
        databaseC.put(player,c);
        databaseManager.saveDatabaseC(databaseC);
        menuAdmin(u);
    }

}

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    private Character addModifier(Character c){
        AddModifier addModifier = new AddModifier();
        c =  addModifier.AddModifier(c);
        return  c;
    }

    private Character addWeapon(Character c){
        AddWeapon addWeapon = new AddWeapon();
        c = addWeapon.AddWeapon(c);
        return c;
    }

    private Character addArmor(Character c){
        AddArmor addArmor = new AddArmor();
        c = addArmor.AddArmor(c);
        return c;
    }

    private Character addMinions(Character c){
        AddMinion addMinion = new AddMinion();
        c.setMinionMap(addMinion.AddMinion(c.getMinionMap()));
        return c;

    }
    private void menuAdmin(User u){
        MenuAdmin menuAdmin = new MenuAdmin();
        menuAdmin.MenuAdmin(u);
    }

}
