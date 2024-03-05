import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeleteCharacter  implements Serializable {

    private Map<String, Character> databaseC = new HashMap<>();
    private DatabaseManager databaseManager;

    public Character deleteCharacter(User u) {
        databaseManager = new DatabaseManager();
        databaseC = databaseManager.obtainDatabaseC();
        Scanner input = new Scanner(System.in);
        Character aux = databaseC.get(u.getRegisterNumber());
        String  option;
            System.out.println("========== Menu de Borrado de personaje ==========");
            System.out.println("1. Borrar Personaje ");
            System.out.println("2. Salir (cualquier entrada)");
            option = input.nextLine();
            if (option.equals("1")) {
                databaseC.remove(u.getRegisterNumber());
                aux = databaseC.get(u.getRegisterNumber());
                databaseManager.saveDatabaseC(databaseC);
                return aux;
            } else {
                return aux;
            }
    }
    public void deleteCharacter2(User u){
        databaseManager = new DatabaseManager();
        databaseC = databaseManager.obtainDatabaseC();
        databaseC.remove(u.getRegisterNumber());
        databaseManager.saveDatabaseC(databaseC);
    }
        public Map<String, Character> getDatabaseC () {
            return databaseC;
        }

        public void setDatabaseC (Map < String, Character > databaseC){
            this.databaseC = databaseC;
        }

        public DatabaseManager getDatabaseManager () {
            return databaseManager;
        }

        public void setDatabaseManager (DatabaseManager databaseManager){
            this.databaseManager = databaseManager;
        }


}
