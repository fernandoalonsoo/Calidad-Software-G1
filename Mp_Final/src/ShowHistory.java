import javax.xml.crypto.Data;
import java.awt.dnd.DropTarget;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ShowHistory implements Serializable {


    private Map<String, History> databaseH = new HashMap<>();
    private DatabaseManager databaseManager = new DatabaseManager();



    public  void ShowHistory(User u){
        databaseH = databaseManager.obtainDatabaseH();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Historial");
        if (databaseH.get(u.getRegisterNumber()) != null) {
            History listaH = databaseH.get(u.getRegisterNumber());
            if ((listaH == null) || (listaH.getMatches().size() == 0)) {
                System.out.println("Historial vacio");
                String aux1 = scanner.nextLine();
            }else {
                 for (Match element : listaH.getMatches()) {
                        System.out.println("\n[----------------------------------------------------------------]\n");
                        System.out.println("Desafiante: " + element.getDefiant().getName() + " Desafiado: " + element.getDefied().getName() + " Oro apostado: " + element.getGoldBet());
                        System.out.print("Numero de rondas: " + element.getRounds());
                        System.out.print("Dia del conflicto armado: " + element.getDate());
                        if (element.getWinner() == null) {
                            System.out.println(" Ganador: Empate Le quedan esbirros supervivientes: No");
                        } else if (element.isMinionsLeft()) {
                            System.out.println(" Ganador: " + element.getWinner().getName() + " Con esbirros supervivientes: Sí");
                        } else {
                            System.out.println(" Ganador: " + element.getWinner().getName() + ", Con esbirros supervivientes: No");
                        }
                        System.out.println("\n[----------------------------------------------------------------]\n");
                 }
                 String aux = scanner.nextLine();
            }
        }else {
            databaseH = new HashMap<>();
            databaseManager.saveDatabaseH(databaseH);
            System.out.println("Historial vacio");
            String aux1 = scanner.nextLine();
        }
    }


    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }
}
