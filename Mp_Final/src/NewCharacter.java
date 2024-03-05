import java.io.Serializable;
import java.util.*;

public class NewCharacter implements Serializable {
    private Map<String,Character> databaseC = new HashMap<>();
    private DatabaseManager databaseManager;


    public Character NewCharacter(){
        Scanner input = new Scanner(System.in);
        Character nuevoChar = new Character();
        String nombre;
        String tiponuevo ;
        int numero = 0;

        System.out.println("\n[-------------------------------------]");
        System.out.println("          CREACION DE PERSONAJE");
        System.out.println(  "[-------------------------------------]\n");
        System.out.print("--> Introduce tu nombre de personaje:");
        nombre = input.nextLine();
        nuevoChar.setName(nombre);

        System.out.print("--> Introduce la historia de tu personaje:");
        String desc = input.nextLine();

        boolean isVamp = false;
        boolean b = true;
        Random rand = new Random();

        do {
        System.out.println("--> Elije el número de la raza a escoger");

        System.out.println("1: Cazador.");
        System.out.println("2: Licantropo.");
        System.out.println("3: Vampiro.");
            System.out.print("--> ");
       tiponuevo = input.nextLine();

            try {
                numero = Integer.parseInt(String.valueOf(tiponuevo));
            }
            catch (NumberFormatException e){

                System.out.println("Ese caracter es erróneo");

            }
            switch (tiponuevo) {
                case "1" -> {
                    nuevoChar.setType("Cazador");
                    System.out.println("<<Personaje creado correctamente>>");
                    b = false;

                }
                case "2" -> {
                    nuevoChar.setType("Licántropo");
                    System.out.println("<<Personaje creado correctamente>>");
                    b = false;

                }
                case "3" -> {
                    nuevoChar.setType("Vampiro");
                    nuevoChar.setAge(rand.nextInt(20, 101));
                    isVamp = true;
                    System.out.println("<<Personaje creado correctamente>>");
                    b = false;

                }

                default -> System.out.println("No has introducido un entero válido.");
            }

        } while (b);
        nuevoChar.setDescription(desc);
        nuevoChar.setGoldValue(300);
        nuevoChar.sethP(5);
        nuevoChar.setPower(rand.nextInt(0,5));
        nuevoChar.setWins(0);
        nuevoChar.setWeaponSet(newWeapon());
        nuevoChar.setArmorSet(newArmor());
        nuevoChar.setFighting(false);
        nuevoChar.setMinionMap(newMinions(isVamp));


        // nueva habilidad
        Ability ab = new Ability();
        ab.setType(nuevoChar.getType());
        ab.setAttack(rand.nextInt(1,4));
        ab.setDefense(rand.nextInt(1,4));
        nuevoChar.setSpecialAbility(ab);

        // mod
        nuevoChar.setModifierList(newModifiers());



        return nuevoChar;
    }


    private List<Weapon> newWeapon () {

        List<Weapon> listaweapons = new ArrayList<>();
        String nombre;
        String[] nombresArmas = {"Espada", "Hacha", "Martillo", "Lanza", "Arco", "Ballesta", "Pistola", "Rifle", "Cuchillo", "Garra"};
        for (int a = 0 ; a < 5; a++) {
            Weapon nuevoWeapon = new Weapon();
            Random randInt = new Random();
            nombre = nombresArmas[(randInt.nextInt(0, 10))];
            nuevoWeapon.setAttack(randInt.nextInt(1, 4));
            nuevoWeapon.setDefence(randInt.nextInt(0, 3));
            nuevoWeapon.setName(nombre);
            nuevoWeapon.setHands(randInt.nextInt(1, 3));
            nuevoWeapon.setActive(false);
            listaweapons.add(nuevoWeapon);

        }
        return listaweapons;
    }

    private List<Armor> newArmor () {

        List<Armor> listaAr = new ArrayList<>();
        Random randInt = new Random();

        String[] nombresAr = {"Armadura de placas", "Armadura de malla", "Armadura de cuero", "Armadura de escamas", "Armadura de cota de malla con capucha", "Armadura de brigandina", "Armadura de bandido", "Armadura de anillas", "Armadura de anillas", "Armadura de la Orden Sagrada"};
        for (int a = 0 ; a < 5; a++) {
            Armor nuevoAr = new Armor();
            String nombre = nombresAr[(randInt.nextInt(0, 10))];
            nuevoAr.setAttack(randInt.nextInt(1, 4));
            nuevoAr.setDefense(randInt.nextInt(0, 3));
            nuevoAr.setName(nombre);
            nuevoAr.setActive(false);
            listaAr.add(nuevoAr);

        }
        return listaAr;
    }


    private List<Minion> newMinions(boolean vamp){
        List<Minion> minionList= new ArrayList<>();
        Random randInt = new Random();
        String nombre ;


        String[] nombresNombres = {"Kaneki", "Nishiki", "Touka", "Shuu", "Hinami", "MacMenú"};
        ArrayList<TMinion> nombresTm = new ArrayList<>();
        nombresTm.add(TMinion.GHOUL);
        if (!vamp) {
            nombresTm.add(TMinion.HUMAN);
        }
        nombresTm.add(TMinion.DEMON);

        for (int a = 0 ; a < 3; a++) {
            Minion minion = new Minion();
            nombre = nombresNombres[(randInt.nextInt(0, 6))];

            minion.setName(nombre);
            minion.setHitPoints(randInt.nextInt(1, 4));
            if(vamp) {
                minion.setTipominion(nombresTm.get((randInt.nextInt(0, 2))));
            } else{
                minion.setTipominion(nombresTm.get((randInt.nextInt(0, 3))));
            }
            if (minion.getTipominion() == TMinion.DEMON) {
                Demon demon = new Demon();
                demon.setName(minion.getName());
                demon.setHitPoints(minion.getHitPoints());
                demon.setTipominion(TMinion.DEMON);
                List<Minion> nuevalista = new ArrayList<>();
                demon.setPact("Este es un demonio peculiar :)");
                for (int b = 0; b < 3; b++) {

                    Minion nuevominion = new Minion();

                    nuevominion.setName(nombre);
                    nuevominion.setHitPoints(randInt.nextInt(1, 4));
                    nuevalista.add(nuevominion);


                    demon.setMinionList(nuevalista);


                }
                minionList.add(demon);
            }
            else if(minion.getTipominion() == TMinion.GHOUL) {
                Ghoul ghoul = new Ghoul();
                ghoul.setName(minion.getName());
                ghoul.setHitPoints(minion.getHitPoints());
                ghoul.setTipominion(TMinion.GHOUL);
                ghoul.setDependency(randInt.nextInt(1,6));

                minionList.add(ghoul);
            }
            else if (minion.getTipominion() == TMinion.HUMAN) {
                Human human = new Human();
                human.setName(minion.getName());
                human.setHitPoints(minion.getHitPoints());
                human.setTipominion(TMinion.HUMAN);
                TLoyalty[] loy = TLoyalty.values();
                int randomIndex = randInt.nextInt(loy.length);
                human.setLoyalty(loy[randomIndex]);

                minionList.add(human);
            }

        }

        return minionList;

    }
        //modificar 1-5 dos tipos f o d
    private List<Modifiers> newModifiers(){
        List<Modifiers> nuevalista = new ArrayList<>();
        Random rand = new Random();
        int nuevobuff ;
        String nombre;
        String[] nombresBuffos = {"Potencia Arcana", "Agilidad Divina", "Tenacidad Colosal", "Fuerza del Dragón", "Percepción Celestial", "Vitalidad Mágica"};

        for (int a = 0 ; a < 3; a++) {
            Modifiers nuevoMod = new Modifiers();
            nombre = nombresBuffos[rand.nextInt(0,6)];
            nuevoMod.setName(nombre);
            nuevoMod.setActive(false);
            nuevoMod.setValue(rand.nextInt(1, 6));
            nuevobuff = rand.nextInt(0, 2);
                if (nuevobuff == 0) {
                    nuevoMod.setBuff(false);
                }
                else {
                    nuevoMod.setBuff(true);

                }
            nuevalista.add(nuevoMod);

        }



        return nuevalista;
    }

    public Map<String, Character> getDatabaseC() {
        return databaseC;
    }

    public void setDatabaseC(Map<String, Character> databaseC) {
        this.databaseC = databaseC;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }
}
