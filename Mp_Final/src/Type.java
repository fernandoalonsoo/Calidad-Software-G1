import java.io.Serializable;
import java.util.Scanner;

public class Type implements Serializable {
    public Character Type(Character c){
        if (c.getType().equals(TCharacter.VAMPIRE)) {
            System.out.println("El tipo actual de personaje es: Vampiro");
        }else if (c.getType().equals(TCharacter.HUNTER)) {
            System.out.println("El tipo actual de personaje es: Cazador");
        }else{
            System.out.println("El tipo actual de personaje es: Licántropo");
        }
        System.out.print("\n");
        System.out.println("-- Seleccione un personaje --");
        System.out.println("-> Vampiro");
        System.out.println("-> Licántropo");
        System.out.println("-> Cazador");
        Scanner scanner = new Scanner(System.in);
        String nuevoTipo = scanner.nextLine();

        if (nuevoTipo.equalsIgnoreCase("Vampiro") || nuevoTipo.equalsIgnoreCase("Licántropo") || nuevoTipo.equalsIgnoreCase("Cazador")) {
            c.setType(nuevoTipo);
            Ability ab = c.getSpecialAbility();
            TCharacter tc = c.getType();
            ab.setType(tc);
            c.setSpecialAbility(ab);
            if (c.getType().equals(TCharacter.VAMPIRE)) {
                System.out.println("\nTipo actualizado del personaje actualizado a vampiro");
            }else if (c.getType().equals(TCharacter.HUNTER)) {
                System.out.println("\nTipo actualizado del personaje actualizado a cazador");
            }else{
                System.out.println("\nTipo actualizado del personaje actualizado a Licántropo");
            }
            nuevoTipo = scanner.nextLine();
        } else {
            System.out.println("\nTipo inválido. El tipo debe ser Vampiro, Licántropo o Cazador.");
            nuevoTipo = scanner.nextLine();
        }

        return c;
    }
}
