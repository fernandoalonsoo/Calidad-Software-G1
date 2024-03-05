import java.io.Serializable;
import java.util.Scanner;

public class GoldValue implements Serializable {
    public Character GoldValue(Character c) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Oro actual: " + c.getGoldValue());

    //comprobamos que sea un numero
    while (true) {
        System.out.println("Introduce el nuevo valor. Tiene que ser 1 o mayor. (Introduzca 'salir' para regresar al menu):");
        String input = scanner.nextLine();

        //verificamos si se quiere salir del programa
        if (input.equals("salir")) {
            break;
        }

        //verificamos si el input es un número válido entre 0 y 10
        try {
            int value = Integer.parseInt(input);
            if (value >= 1) {
                //asignamos el valor a la variable correspondiente
                c.setGoldValue(value);
                break;
            } else {
                System.out.println("El número debe ser 1 uno o mayor.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Debe introducir un número válido.");
        }
    }
    return c;
}
}
