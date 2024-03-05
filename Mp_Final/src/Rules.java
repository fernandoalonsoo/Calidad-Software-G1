import java.util.Scanner;

public class Rules {


    public void ShowRules(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Reglas");
        System.out.println("1. Cada jugador debe elegir un personaje para pelear, con habilidades, equipo, y esbirros.");
        System.out.println("2. El objetivo del juego es reducir la barra de vida del oponente a cero.");
        System.out.println("3. Para poder pelear le deberas mandar un desafío a quién quieras desafiar ");
        System.out.println("4. No podrás mandar un desafío a un jugador que haya perdido en el último día o podrás ser baneado ");
        System.out.println("5. La pelea se divide en rondas, donde cada jugador tira un dado para realizar una accion, en caso de éxito se comparan potenciales y el que tenga mas daño que defensa al segundo jugador le quita un pinto de vida");
        System.out.println("6. Cada personaje tiene unas caracteristicas unicas que varían a lo largo de la pelea");
        String a = scanner.nextLine();
    }
}
