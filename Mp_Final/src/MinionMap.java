
import java.util.*;

public class MinionMap {
    public Character MinionMap(Character c) {
        int j = 0;
        for (int i = 0; i < c.getMinionMap().size(); i++) {
            Minion minion = c.getMinionMap().get(i);
            System.out.println("----------------[Conjunto de esbirros]-----------------");
            System.out.println("----------------------------------------------------");
            System.out.println("----------------[ " + (i + 1) + " ]-----------------");
            System.out.println((i + 1) + ". " + minion.getName());
            System.out.println(("Puntos de vida") + " - " + minion.getHitPoints());
            System.out.println(("Tipo de esbirro") + " - " + minion.getTipominion());
            j  = i;
        }
        Scanner scanner = new Scanner(System.in);
        int minionIndex = -2;
        do {
            System.out.print("Seleccione el número de esbirro que desea modificar (Introduzca '0' para regresar al menu): ");

            String aux = scanner.nextLine();
            try {
                minionIndex = Integer.parseInt(aux) - 1;
                if (minionIndex < -1 || minionIndex > j) {
                    System.out.println("Número no válido");
                }
            } catch (Exception e) {
                System.out.println("Caracter no numeral");
            }
        }while (minionIndex < -1 || minionIndex > j);
        if (minionIndex == -1) {
            return c;
        } else if (c.getMinionMap().get(minionIndex) != null) {
            String option;
            do {
                Minion minion = c.getMinionMap().get(minionIndex);
                System.out.println("Modificando esbirro: " + minion.getName());
                System.out.println("Seleccione la característica que desea modificar: ");
                System.out.println("1. Nombre");
                System.out.println("2. Puntos de vida");
                System.out.println("3. Tipo de Minion");
                option = scanner.nextLine();
                List<Minion> minionMap = c.getMinionMap();
                switch (option) {
                    case "1" -> {
                        System.out.print("Ingrese el nuevo nombre: ");
                        String newName = scanner.nextLine();
                        minion.setName(newName);
                        minionMap.set(minionIndex, minion);
                        c.setMinionMap(minionMap);
                    }
                    case "2" -> {
                        int hp = 0;
                        while (hp < 1 || hp > 3) {
                            System.out.print("Ingrese el nuevo valor de puntos de vida (entre 1 y 3): ");
                            String aux = scanner.nextLine();
                            try {
                                hp = Integer.parseInt(aux) - 1;
                                if (hp < 1 || hp > 3) {
                                    System.out.println("Número no válido");
                                }
                            } catch (Exception e) {
                                System.out.println("Caracter no numeral");
                            }
                            minionMap.set(minionIndex, minion);
                            c.setMinionMap(minionMap);
                        }
                        minion.setHitPoints(hp);
                    }
                    case "3" -> {
                        String nuevoTipo;
                        do {
                            System.out.println("El tipo actual de esbirro es " + minion.getTipominion());
                            System.out.print("\n");
                            System.out.println("       -- Seleccione un tipo --");
                            System.out.println("-> Humano");
                            System.out.println("-> Ghoul");
                            System.out.println("-> Demonio");
                            System.out.println("-->");
                            nuevoTipo = scanner.nextLine();
                        }while (!nuevoTipo.equalsIgnoreCase("humano") && !nuevoTipo.equalsIgnoreCase("ghoul") && !nuevoTipo.equalsIgnoreCase("demonio"));
                        if (nuevoTipo.equals("humano")) {
                            Random rand = new Random();
                            Human human = new Human();
                            human.setHitPoints(minion.getHitPoints());
                            human.setTipominion(TMinion.HUMAN);
                            human.setName(minion.getName());
                            TLoyalty[] loy = TLoyalty.values();
                            int randomIndex = rand.nextInt(loy.length);
                            human.setLoyalty(loy[randomIndex]);

                            minionMap.set(minionIndex, human);
                            c.setMinionMap(minionMap);
                        } else if (nuevoTipo.equals("ghoul")) {
                            Random rand = new Random();
                            Ghoul ghoul = new Ghoul();
                            ghoul.setName(minion.getName());
                            ghoul.setTipominion(TMinion.GHOUL);
                            ghoul.setHitPoints(minion.getHitPoints());
                            int randomIndex = rand.nextInt(3) + 1;
                            ghoul.setDependency(randomIndex);
                            minionMap.set(minionIndex, ghoul);
                            c.setMinionMap(minionMap);
                        } else {
                            Demon demon = new Demon();
                            demon.setHitPoints(minion.getHitPoints());
                            demon.setName(minion.getName());
                            demon.setTipominion(TMinion.DEMON);
                            System.out.println("¿Cuál es el pacto?");
                            System.out.println("-->");
                            String pacto = scanner.nextLine();
                            demon.setPact(pacto);
                            System.out.println("¿Quieres añadir un esbirro al demonio, 'S' si si otra cosa si no");
                            System.out.println("-->");
                            String opt = scanner.nextLine();
                            List<Minion> minList = new ArrayList<>();
                            while (opt.equalsIgnoreCase("S")) {
                                AddMinion addMinion = new AddMinion();
                                minList = addMinion.AddMinion(minList);
                                System.out.println("¿Quieres añadir otro esbirro al demonio (S/N)");
                                System.out.println("-->");
                                opt = scanner.nextLine();
                            }
                            demon.setMinionList(minList);
                            demon.setPact(pacto);
                            minionMap.set(minionIndex, demon);
                            c.setMinionMap(minionMap);
                        }
                    }
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }
            }while(!option.equals("1") && !option.equals("2") && !option.equals("3"));

            System.out.println("Característica modificada correctamente.");
            return c;
        }
        System.out.println("Esbirro no encontrado");
        return c;
    }
}
