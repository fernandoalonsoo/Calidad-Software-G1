import java.io.Serializable;
import java.util.*;

public class AddMinion implements Serializable {


    public List<Minion> AddMinion(List<Minion> m) {
        Minion newMinion = new Minion();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Si quiere salir escriba 'salir':");
        String salir = scanner.nextLine();
        if (salir.equalsIgnoreCase("salir")) {
            return m;
        }
        System.out.print("Ingrese el nombre del nuevo esbirro: ");
        String name = scanner.nextLine();
        newMinion.setName(name);
        int a = -1;
        boolean valid = false;
        do {
            System.out.print("Ingrese la vida del nuevo esbirro (entre 1 y 3): ");
            String hP = scanner.nextLine();
            try {
                a = Integer.parseInt(hP);
                if (a < 1 || a > 3) {
                    System.out.println("Número no válido");
                } else {
                    valid = true;
                }
            } catch (Exception e) {
                System.out.println("El valor no es un número o no es válido");
            }

        } while (!valid);

        newMinion.setHitPoints(a);

        boolean aux = false;
        while (!aux) {
            System.out.print("Ingrese el tipo del nuevo esbirro (Ghoul, Humano o Demonio): ");
            String type = scanner.nextLine();
            aux = type.equalsIgnoreCase("ghoul") || (type.equalsIgnoreCase("humano")) || type.equalsIgnoreCase("demonio");


            if (type.equalsIgnoreCase("ghoul")) {
                type = "Ghoul";
            } else if (type.equalsIgnoreCase("humano")) {
                type = "Humano";
            } else if (type.equalsIgnoreCase("demonio")) {
                type = "Demonio";

            }


            switch (type) {
                case "Humano" -> {
                    Random rand = new Random();
                    Human human = new Human();
                    TLoyalty[] loy = TLoyalty.values();
                    int randomIndex = rand.nextInt(loy.length);
                    human.setName(newMinion.getName());
                    human.setHitPoints(newMinion.getHitPoints());
                    human.setLoyalty(loy[randomIndex]);
                    human.setTipominion(TMinion.HUMAN);

                    m.add(human);
                }
                case "Ghoul" -> {

                    Random rand = new Random();
                    Ghoul ghoul = new Ghoul();
                    int randomIndex = rand.nextInt(1, 6);
                    ghoul.setTipominion(TMinion.GHOUL);
                    ghoul.setHitPoints(newMinion.getHitPoints());
                    ghoul.setName(newMinion.getName());
                    ghoul.setDependency(randomIndex);
                    m.add(ghoul);

                }
                case "Demonio" -> {
                    newMinion.setTipominion(TMinion.DEMON);
                    Demon demon = new Demon();
                    demon.setName(newMinion.getName());
                    demon.setTipominion(TMinion.DEMON);
                    demon.setHitPoints(newMinion.getHitPoints());

                    System.out.println("¿Cuál es el pacto?");
                    System.out.println("-->");
                    String pacto = scanner.nextLine();
                    demon.setPact(pacto);
                    System.out.println("¿Quieres añadir un minion al demonio (S/N)");
                    System.out.println("-->");
                    String opt = scanner.nextLine();
                    List<Minion> minList = new ArrayList<>();
                    while (opt.equalsIgnoreCase("S")) {
                        AddMinion addMinion = new AddMinion();
                        minList = addMinion.AddMinion(minList);
                        System.out.println("¿Quieres añadir otro minion al demonio (S/N)");
                        System.out.println("-->");
                        opt = scanner.nextLine();
                    }
                    demon.setMinionList(minList);
                    demon.setPact(pacto);
                    m.add(demon);
                }
                default -> System.out.println("Tipo erróneo");

            }

        }
        System.out.println("Esbirro añadido correctamente");
        return m;

    }
}
