import javax.swing.*;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class SpecialAbility implements Serializable {

    public Character SpecialAbility(Character c) {

        Ability ability = c.getSpecialAbility();
        System.out.println("----------------[Habilidad especial]-----------------");
        System.out.println("----------------------------------------------------");
        System.out.println(("Ataque") + " - " + ability.getAttack());
        System.out.println(("Defensa") + " - " + ability.getDefense());

        Scanner scanner = new Scanner(System.in);
        String option;
        do {
        System.out.println("Seleccione la característica que desea modificar o escriba 0 para salir: ");
        System.out.println("1. Ataque");
        System.out.println("2. Defensa");
        option = scanner.nextLine();
        switch (option) {
            case "0":
                break;
            case "1":
                int newAttack = 0;
                while (newAttack < 1 || newAttack > 3) {
                    System.out.print("Ingrese el nuevo valor de ataque (entre 1 y 3): ");
                    String aux = scanner.nextLine();
                    try {
                        newAttack = Integer.parseInt(aux) ;
                        if (newAttack < 1 || newAttack > 3) {
                            System.out.println("Número no válido");
                        }
                    } catch (Exception e) {
                        System.out.println("Caracter no numeral");
                    }                }
                ability.setAttack(newAttack);
                break;
            case "2":
                int newDefense = 0;
                while (newDefense < 1 || newDefense > 3) {
                    System.out.print("Ingrese el nuevo valor de defensa (entre 1 y 3): ");
                    String aux = scanner.nextLine();
                    try {
                        newDefense = Integer.parseInt(aux);
                        if (newDefense < 1 || newDefense > 3) {
                            System.out.println("Número no válido");
                        }
                    } catch (Exception e) {
                        System.out.println("Caracter no numeral");
                    }                 }
                ability.setDefense(newDefense);
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
                System.out.println("Magia");
                break;
        }
        }while (!option.equals("1") && !option.equals("2"));
        System.out.println("Característica modificada correctamente.");
        c.setSpecialAbility(ability);
        return c;
    }
}
