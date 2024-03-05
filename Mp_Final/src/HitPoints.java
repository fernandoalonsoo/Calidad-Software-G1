import java.io.Serializable;
import java.util.Scanner;

public class HitPoints implements Serializable {

    public Character HitPoints(Character c) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Puntos de vida actuales: " + c.gethP());

        //comprobamos que sea un numero
        while (true) {
            System.out.println("Introduce el nuevo valor [0-10] (Introduzca 'salir' para regresar al menu):");
            String input = scanner.nextLine();

            //verificamos si se quiere salir del programa
            if (input.equals("salir")) {
                break;
            }

            //verificamos si el input es un número válido entre 0 y 10
            try {
                int value = Integer.parseInt(input);
                if (value >= 0 && value <= 10) {
                    //asignamos el valor a la variable correspondiente
                    c.sethP(value);
                    break;
                } else {
                    System.out.println("El número debe estar entre 0 y 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número válido.");
            }
        }
        return c;
    }
}