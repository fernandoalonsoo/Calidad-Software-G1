import java.awt.dnd.DropTarget;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class ShowRanking implements Serializable {
    private Map<String, Character> databaseR = new HashMap<>();
    private DatabaseManager databaseManager = new DatabaseManager();
    private final Ranking rank = new Ranking();


    public void ShowRanking(){
        databaseR = databaseManager.obtainDatabaseC();

        List<Character> characters = new ArrayList<>(databaseR.values());
        characters = rank.Ranking(characters);
        System.out.println("[-----------Ranking-----------]");
        for (Character c : characters) {
            System.out.println("Personaje: " + c.getName() + " Victorias: " + c.getWins());
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


    public Map<String, Character> getDatabaseR() {
        return databaseR;
    }

    public void setDatabaseR(Map<String, Character> databaseR) {
        this.databaseR = databaseR;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }
}
