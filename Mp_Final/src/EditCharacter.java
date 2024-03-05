import java.io.Serializable;
import java.util.*;

public class EditCharacter implements Serializable {

    private DatabaseManager databaseManager;
    private Map<String, Character> databaseC = new HashMap<>();
    private Map<String, User> databaseU = new HashMap<>();



    public void EditCharacter(User u) {
        databaseManager = new DatabaseManager();
        databaseC = databaseManager.obtainDatabaseC();
        databaseU = databaseManager.obtainDatabaseU();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n[-------------------------------------]");
        System.out.println("             EDITAR PERSONAJE");
        System.out.println("[-------------------------------------]\n");
        System.out.println("     [---------------- LISTA DE USUARIOS -------------] ");
        Set<String> keyset = databaseU.keySet();

        for (String key : keyset) {
            User user = databaseU.get(key);
            if (user != null) {
                if (!user.getName().startsWith("¬")){
                    System.out.println("                 >Usuario: " + user.getName());
                    System.out.println("                 >Numero de registro: " + user.getRegisterNumber());
                    System.out.println("     ------------------------------------------------- ");}
            }}

        System.out.println();
        String player;
        do {
            System.out.print("Ingrese el numero de registro del jugador a editar('salir' para salir) :");
            player = scanner.nextLine();
            if (player.equalsIgnoreCase("salir")) { // Agregamos verificación de "salir"
                System.out.println("Saliendo...");
                return;
            }else if(databaseC.get(player) == null) {
                System.out.println("El jugador no tiene personajes.");
                player = scanner.nextLine();
            }
        } while (databaseC.get(player) == null);

        Character c = databaseC.get(player);
        scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menú de edición de personaje ---");
            System.out.println("1.  Editar nombre");
            System.out.println("2.  Editar tipo");
            System.out.println("3.  Editar equipo de armas");
            System.out.println("4.  Editar equipo de armadura");
            System.out.println("5.  Editar puntos de vida");
            System.out.println("6.  Editar poder");
            System.out.println("7.  Editar mapa de esbirros");
            System.out.println("8.  Editar descripción");
            System.out.println("9.  Editar habilidades especiales");
            System.out.println("10. Editar valores de oro");
            System.out.println("11. Editar lista de modificadores");
            System.out.println("12. Editar victorias");
            System.out.println("13. Salir");
            System.out.println("Seleccione una opción:");

            String option = scanner.nextLine();

            int numberOption;
            try {
                numberOption = Integer.parseInt(option);
            } catch (NumberFormatException e) {
                System.out.println("La opción ingresada no es válida. Por favor, ingrese un número del 1 al 13.");
                continue;
            }

            if ((numberOption < 1) || (numberOption > 13)) {
                System.out.println("La opción ingresada no es válida. Por favor, ingrese un número del 1 al 13.");
                continue;
            }


            switch (numberOption) {
                case 1 -> {
                    c = editName(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Nombre editado.");
                }
                case 2 -> {
                    c = editType(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Tipo editado.");
                }
                case 3 -> {
                    c = editWeaponSet(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Equipo de armas editado.");

                }
                case 4 -> {
                    c = editArmor(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Equipo de armaduras editado.");
                }
                case 5 -> {
                    c = editHitPoints(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Puntos de vida editados.");
                }
                case 6 -> {
                    c = editPower(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Poder editado.");
                }
                case 7 -> {
                    c = editMinionMap(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Mapa de secuaces editado.");
                }
                case 8 -> {
                    c = editDescription(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Descripción editada.");
                }
                case 9 -> {
                    c = editSpecialAbilities(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Habilidades especiales editadas.");
                }
                case 10 -> {
                    c = editGoldValues(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Valores de oro editados.");
                }
                case 11 -> {
                    c = editModifiersList(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Lista de modificadores editada.");
                }
                case 12 -> {
                    c = editWins(c);
                    databaseC.put(player, c);
                    databaseManager.saveDatabaseC(databaseC);
                    System.out.println("Victorias editadas.");
                }
                case 13-> {
                    System.out.println("Saliendo...");
                    exit = true;
                }
                default -> System.out.println("Opción no válida. Vuelva a intentarlo.");
            }
        }
        menuAdmin(u);
    }

    private void menuAdmin(User u){
        MenuAdmin menuAdmin = new MenuAdmin();
        menuAdmin.MenuAdmin(u);

    }
    private Character editName (Character c){
        Name name = new Name();
        c = name.Name(c);
        return c;
    }
    private Character editType (Character c){  //Type
        Type editType = new Type();
        c = editType.Type(c);
        return c;
    }

    private Character editWeaponSet (Character c){ //WeaponSet
        WeaponSet weaponSet = new WeaponSet();
        c = weaponSet.WeaponSet(c);
        return c;
    }
    private Character editArmor (Character c){
        ArmorSet armorSet = new ArmorSet();
        c = armorSet.ArmorSet(c);
        return c;
    }

    private Character editHitPoints (Character c){
        HitPoints HitPoints = new HitPoints();
        c = HitPoints.HitPoints(c);
        return c;
    }

    private Character editPower (Character c){
        Power Power = new Power();
        c = Power.Power(c);
        return c;
    }

    private Character editMinionMap (Character c){
        MinionMap minionMap = new MinionMap();
        c = minionMap.MinionMap(c);
        return c;
    }

    private Character editDescription (Character c){
        Description description = new Description();
        c = description.Description(c);
        return c;
    }
    private Character editSpecialAbilities (Character c){
        SpecialAbility specialAbilities = new SpecialAbility();
        c = specialAbilities.SpecialAbility(c);
        return c;
    }
    private Character editGoldValues (Character c){
        GoldValue goldValues = new GoldValue();
        c = goldValues.GoldValue(c);
        return c;
    }
    private Character editModifiersList (Character c){
        ModifierList modifiersList = new ModifierList();
        c = modifiersList.ModifierList(c);
        return c;
    }
    private Character editWins (Character c){
        Wins wins = new Wins();
        c = wins.Wins(c);
        return c;
    }


    public DatabaseManager getDatabaseManager () {
        return databaseManager;
    }

    public void setDatabaseManager (DatabaseManager databaseManager){
        this.databaseManager = databaseManager;
    }

    public Map<String, Character> getDatabaseC () {
        return databaseC;
    }

    public void setDatabaseC (Map < String, Character > databaseC){
        this.databaseC = databaseC;
    }
}


