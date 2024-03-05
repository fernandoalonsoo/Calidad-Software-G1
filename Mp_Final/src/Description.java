import java.io.Serializable;
import java.util.Scanner;

public class Description implements Serializable {

    public Character Description(Character c) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEditar descripción:");
            System.out.println("La descripción actual es: " + c.getDescription());
            System.out.print("\nIngrese la nueva descipción (Introduce 'salir' para regresar al menu)");
            String option = scanner.nextLine();

            //verificamos si se quiere salir del programa
            if (option.equals("salir")) {
                break;  // no hace falta else por el break
            }
            c.setDescription(option);
            break;
        }
        return c;
    }
}
