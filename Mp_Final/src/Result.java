
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Result implements Serializable {

    private Map<String, History> databaseH = new HashMap<>();

    private Map<String, Character> databaseC = new HashMap<>();
    private DatabaseManager databaseManager;




    public void showResult(Combat combat, User user){
        List<Round> rondas = combat.getRoundList();
        int i = 1;
        System.out.println("Número de rondas:" + combat.getRounds());
        for (Round ronda : rondas) {
            int hpdefiant = ronda.getDefiantInfo().getFighterHP();
            int hpdefied = ronda.getDefiedInfo().getFighterHP();
            List<Integer> dañoronda =  ronda.getDamageDealt();

            System.out.println("-----Ronda " + i + "--------");
            System.out.println("Vida del desafiante: " + hpdefiant );
            System.out.println("Vida de los esbirros del desafiante: " + ronda.getDefiantInfo().getMinionHP() );
            System.out.println("Daño del desafiante al desafiado: " + dañoronda.get(0) );
            System.out.println("---------------------------------");
            System.out.println("Vida del desafiado: " + hpdefied  );
            System.out.println("Vida de los esbirros del desafiado: " + ronda.getDefiedInfo().getMinionHP() );
            System.out.println("Daño del desafiado al desafiante: " + dañoronda.get(1) );
            System.out.println("---------------------------------");
            i += 1;
        }

        System.out.println("Oro apostado:" + combat.getGoldBet());
        State ganador = combat.getState();

        switch (ganador) {

            case VDEFIANT -> {
            System.out.println("---------Ganó "+  rondas.get(0).getDefiantInfo().getName() +"-------");
            System.out.println("---------------------------------");



            }
            case VDEFIED -> {

                System.out.println("---------Ganó "+  rondas.get(0).getDefiedInfo().getName() +"-------");
                System.out.println("---------------------------------");


            }
            case DRAW -> {
                System.out.println("--------------Empate---------------");
                System.out.println("-----------------------------------");

            }
        }

        Scanner scanner = new Scanner(System.in);


        System.out.println("<<Presiona enter para continuar>>");
        String aux = scanner.nextLine();
        menu(user);

    }
    private void menu(User u){
        Menu menu = new Menu();
        menu.Menu(u);
    }

    public Map<String, Character> getDatabaseC() {
        return databaseC;
    }

    public void setDatabaseC(Map<String, Character> databaseC) {
        this.databaseC = databaseC;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }
}
