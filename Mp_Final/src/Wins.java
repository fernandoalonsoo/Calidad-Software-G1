import java.io.Serializable;
import java.util.Scanner;

public class Wins{

    public Character Wins(Character c) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Victorias actuales: " + c.getWins());

        //comprobamos que sea un numero
        while (true) {
            System.out.println("Introduce el nuevo valor (Introduzca 'salir' para regresar al menu):");
            String input = scanner.nextLine();

            //verificamos si se quiere salir del programa
            if (input.equals("salir")) {
                break;
            }

            try {
                int value = Integer.parseInt(input);
                //asignamos el valor a la variable correspondiente
                c.setWins(value);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número válido.");
            }
        }
        return c;
    }
}
