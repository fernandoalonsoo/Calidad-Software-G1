import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.io.Serializable;

public class Login implements Serializable {

    private DatabaseManager databaseManager;
    private Map<String, User> databaseU = new HashMap<>();


    public void Login(){
        databaseManager = new DatabaseManager();
        Scanner input = new Scanner(System.in);
        String username, password, truepassword;
        databaseU = databaseManager.obtainDatabaseU();
        boolean valid = false ;
        User user;
        TUser tipouser = TUser.ADMIN;
        System.out.print("\n<><><><><><><><><><><><><><><><><><><>\n");
        System.out.println("\n[-------------------------------------]");
        System.out.println("                LOGIN");
        System.out.println("[-------------------------------------]\n");
        do {
            do {
                do {
                    System.out.print("--> Introduce tu nombre (escribe 'salir' para salir): ");
                    username = input.nextLine();
                    if (username.equalsIgnoreCase("salir")){
                        this.welcome();
                        break;
                    }
                    if(databaseU.get(username) == null){
                        System.out.println("               <<Nombre no existente>>");
                    }
                }while(databaseU.get(username) == null);

                user = databaseU.get(username);
                truepassword = user.getPassword();

                System.out.print("--> Introduce tu contraseña: ");
                password = input.nextLine();
                if(!truepassword.equals(password)){
                    System.out.println("    <<Contraseña incorrecta>>");
                }
            }while(!truepassword.equals(password));
            if (!user.isBanned()) {
                System.out.print("    <<Login correcto>>");
                System.out.println();
                valid = true;

                if (user.getUsertype() == tipouser) {
                    menuAdmin(user);

                } else {
                    menu(user);

                }
            } else {
                System.out.print("Usuario baneado");
            }
        } while (!valid);
    }

    private void menuAdmin(User u){
        MenuAdmin menuAdmin = new MenuAdmin();
        menuAdmin.MenuAdmin(u);

    }

    private void menu(User u){
        Menu menu = new Menu();
        menu.Menu(u);

    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;

    }

    public void welcome(){
        Welcome welcome = new Welcome();
        welcome.Welcome();

    }
}
