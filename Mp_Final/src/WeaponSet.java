import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WeaponSet {
    public Character WeaponSet(Character c) {
        int j = 0;
        for (int i = 0; i < c.getWeaponSet().size(); i++) {
                Weapon weapon = c.getWeaponSet().get(i);
                System.out.println("----------------[Conjunto de armas]-----------------");
                System.out.println("----------------------------------------------------");
                System.out.println("----------------[ " + (i + 1) + " ]-----------------");
                System.out.println((i + 1) + ". " + weapon.getName());
                System.out.println(("Ataque") + " - " + weapon.getAttack());
                System.out.println(("Defensa") + " - " + weapon.getDefence());
                System.out.println(("Manos") + " - " + weapon.getHands());
                j = i;
        }
        Scanner scanner = new Scanner(System.in);
        int weaponIndex = -2;
        while (weaponIndex < -1 || weaponIndex > j) {
            System.out.print("Seleccione el número de arma que desea modificar(Introduzca '0' para regresar al menu): ");
            String aux = scanner.nextLine();
            try {
                weaponIndex = Integer.parseInt(aux) - 1;
                if (weaponIndex < -1 || weaponIndex > j) {
                    System.out.println("Número no válido");
                }
            } catch (Exception e) {
                System.out.println("Caracter no numeral");
            }
        }
        if (weaponIndex == -1) {
            return c;
        } else if (c.getWeaponSet().get(weaponIndex) != null) {
        Weapon weapon = c.getWeaponSet().get(weaponIndex);
        System.out.println("Modificando arma: " + weapon.getName());
        System.out.println("Seleccione la característica que desea modificar: ");
        System.out.println("1. Nombre");
        System.out.println("2. Ataque");
        System.out.println("3. Defensa");
        System.out.println("4. Manos");
        String option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = scanner.nextLine();
                    weapon.setName(newName);
                }
                case "2" -> {
                    int newAttack = 0;
                    while (newAttack < 1 || newAttack > 3) {
                        System.out.print("Ingrese el nuevo valor de ataque (entre 1 y 3): ");
                        String aux = scanner.nextLine();
                        try {
                            newAttack = Integer.parseInt(aux);
                            if (newAttack < 1 || newAttack > 3) {
                                System.out.println("Número no válido");
                            }
                        } catch (Exception e) {
                            System.out.println("Caracter no numeral");
                        }
                    }
                    weapon.setAttack(newAttack);
                }
                case "3" -> {
                    int newDefense = 0;
                    while (newDefense < 1 || newDefense > 3) {
                        System.out.print("Ingrese el nuevo valor de defensa (entre 1 y 3): ");
                        String aux1 = scanner.nextLine();
                        try {
                            newDefense = Integer.parseInt(aux1);
                            if (newDefense < 1 || newDefense > 3) {
                                System.out.println("Número no válido");
                            }
                        } catch (Exception e) {
                            System.out.println("Caracter no numeral");
                        }
                    }
                    weapon.setDefence(newDefense);
                }
                case "4" -> {
                    int newHands = 0;
                    while (newHands < 1 || newHands > 2) {
                        System.out.print("Ingrese el nuevo valor de manos (entre 1 y 2): ");
                        String aux2 = scanner.nextLine();
                        try {
                            newHands = Integer.parseInt(aux2);
                            if (newHands < 1 || newHands > 2) {
                                System.out.println("Número no válido");
                            }
                        } catch (Exception e) {
                            System.out.println("Caracter no numeral");
                        }
                    }
                    weapon.setHands(newHands);
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        if (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4")){
            System.out.println("Característica modificada correctamente.");
        }
        List<Weapon> weaponList = c.getWeaponSet();
        weaponList.add(weaponIndex,weapon);
        c.setWeaponSet(weaponList);

        return c;
    }
    System.out.println("Arma no encontrada");
    return c;
}
}
