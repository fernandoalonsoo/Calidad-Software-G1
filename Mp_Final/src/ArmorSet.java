import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class ArmorSet implements Serializable {
    public Character ArmorSet(Character c){
        int j = 0;
        System.out.println("----------------[Conjunto de armaduras]-----------------");
        for(int i = 0; i<c.getArmorSet().size();i++) {
            Armor armor = c.getArmorSet().get(i);
            System.out.println("----------------------------------------------------");
            System.out.println("----------------[ " + (i + 1) + " ]-----------------");
            System.out.println((i + 1) + ". " + armor.getName());
            System.out.println(("Ataque") + " - " + armor.getAttack());
            System.out.println(("Defensa") + " - " + armor.getDefense());
            j = i;
        }
        int armorIndex =-2;
        Scanner scanner = new Scanner(System.in);
        while (armorIndex < -1 || armorIndex > j) {
            System.out.print("Seleccione el número de armadura que desea modificar (Introduzca '0' para regresar al menu): ");
            String aux = scanner.nextLine();
            try {
                armorIndex = Integer.parseInt(aux) - 1;
                if (armorIndex < -1 || armorIndex > j) {
                    System.out.println("Número no válido");
                }
            } catch(Exception e) {
                System.out.println("Caracter no numeral");
            }
        }
        if (armorIndex == -1){
            return c;
        } else if (c.getArmorSet().get(armorIndex) != null) {
            Armor armor = c.getArmorSet().get(armorIndex);
            System.out.println("Modificando armadura: " + armor.getName());
            System.out.println("Seleccione la característica que desea modificar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Ataque");
            System.out.println("3. Defensa");
            String option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                    System.out.print("Ingrese el nuevo nombre: ");

                    String newName = scanner.nextLine();
                    armor.setName(newName);
                }
                case "2" -> {
                    int newAttack = -1;
                    while (newAttack < 0 || newAttack > 3) {
                        System.out.print("Ingrese el nuevo valor de ataque (entre 0 y 3): ");

                        String aux = scanner.nextLine();
                        try {
                            newAttack = Integer.parseInt(aux);
                            if (newAttack < 1 || newAttack > 3) {
                                System.out.println("Número no válido");
                            }
                        } catch (Exception e) {
                            System.out.println("Caracter no numeral");
                        }

                        armor.setAttack(newAttack);
                    }
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
                    armor.setDefense(newDefense);
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
            if (option.equals("1") || option.equals("2") || option.equals("3")) {
                System.out.println("Característica modificada correctamente.");
            }
            List<Armor> armorList = c.getArmorSet();
            armorList.add(armorIndex, armor);
            c.setArmorSet(armorList);
            return c;
        }
        System.out.println("Armadura no encontrada");
        return c;
    }
}


