import java.io.Serializable;
import java.util.Scanner;

public class Name implements Serializable {
    public Character Name (Character c){
        System.out.println("El nombre actual del personaje es: " + c.getName());
        System.out.println("Escribe el nuevo nombre para el personaje (Introduzca 'salir' para regresar al menu)");
        System.out.print("Escribe dos veces el nombre para confirmar: ");
        Scanner scanner = new Scanner(System.in);
        String nuevoNombre = scanner.nextLine();
        if (nuevoNombre.equalsIgnoreCase("salir")) {
            return  c;
        }
        String confirmacionNombre = scanner.nextLine();
        if (nuevoNombre.equals(confirmacionNombre)) {
            c.setName(nuevoNombre);
            System.out.println("El nombre del personaje se ha cambiado correctamente a " + c.getName());
            String a = scanner.nextLine();
        } else {
            System.out.println("Los nombres no coinciden. No se ha cambiado el nombre del personaje.");
            String a = scanner.nextLine();
        }
    return c;

    }
}
