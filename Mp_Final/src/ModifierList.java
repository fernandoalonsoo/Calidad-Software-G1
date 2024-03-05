import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Scanner;

public class ModifierList {

    public Character ModifierList(Character c){
        int j =0;
        for (int i = 0; i < c.getModifiersList().size(); i++) {
            Modifiers modi = c.getModifiersList().get(i);
            System.out.println("----------------[Conjunto de Modificadores]-----------------");
            System.out.println("----------------------------------------------------");
            System.out.println("----------------[ " + (i + 1) + " ]-----------------");
            System.out.println((i + 1) + ". " + modi.getName());
            System.out.print(("Fortaleza/Debilidad") + (" - "));
            if (modi.isBuff()){
                System.out.println("Fortaleza");
            }else{
                System.out.println("Debilidad");
            }
            System.out.println(("Valor") + " - " + modi.getValue());
            j = i;
        }
        int modiIndex =-2;
        Scanner scanner = new Scanner(System.in);
        while (modiIndex < -1 || modiIndex > j) {
            System.out.print("Seleccione el número de modificador que desea cambiar (Introduzca '0' para regresar al menu): ");
            String aux = scanner.nextLine();
            try {
                modiIndex = Integer.parseInt(aux) - 1;
                if (modiIndex < -1 || modiIndex > j) {
                    System.out.println("Número no válido");
                }
            } catch (Exception e) {
                System.out.println("Caracter no numeral");
            }
        }
        if (modiIndex == -1) {
            return c;
        } else if (c.getModifiersList().get(modiIndex) != null) {
        Modifiers modi = c.getModifiersList().get(modiIndex);
        System.out.println("Modificando modificador: " + modi.getName());
        System.out.println("Seleccione la característica que desea modificar: ");
        System.out.println("1. Nombre");
        System.out.println("2. Debilidad o Fortaleza");
        System.out.println("3. Valor");
        String option = scanner.nextLine();
        switch (option) {
            case "1" -> {
                System.out.print("Ingrese el nuevo nombre: ");

                String newName = scanner.nextLine();
                modi.setName(newName);
            }
            case "2" -> {
                if (modi.isBuff()) {
                    System.out.println("Ha pasado de ser una fortaleza a ser una debilidad");
                } else {
                    System.out.println("Ha pasado de ser una debilidad a ser una fortaleza");
                }
                modi.setBuff(!modi.isBuff());
            }
            case "3" -> {
                int newValue = 0;
                while (newValue < 1 || newValue > 5) {
                    System.out.print("Ingrese el nuevo valor (entre 1 y 5): ");
                    String aux2 = scanner.nextLine();
                    try {
                        newValue = Integer.parseInt(aux2);
                        if (newValue < 1 || newValue > 5) {
                            System.out.println("Número no válido");
                        }
                    } catch (Exception e) {
                        System.out.println("Caracter no numeral");
                    }
                }
                modi.setValue(newValue);
            }
            default -> System.out.println("Opción inválida. Intente nuevamente.");
        }
         if (option.equals("1") || option.equals("2") || option.equals("3")){
             System.out.println("Característica modificada correctamente.");
         }
        List<Modifiers> modifiers = c.getModifiersList();
        modifiers.set(modiIndex,modi);
        c.setModifierList(modifiers);
        return c;
    }
    System.out.println("Modificador no encontrado");
    return c;
    }
}
