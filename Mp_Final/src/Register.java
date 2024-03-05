import java.io.Serializable;
import java.util.*;


public class Register implements Serializable {
    private DatabaseManager databaseManager;
    private static Map<String, User> databaseU = new HashMap<>();


    public void Register(){
            databaseManager = new DatabaseManager();
            databaseU = databaseManager.obtainDatabaseU();
            Scanner input = new Scanner(System.in);
            String username, password, nickname = null;
            User user = new User();



            System.out.print("\n<><><><><><><><><><><><><><><><><><><>\n");
            System.out.println("\n[-------------------------------------]");
            System.out.println("               REGISTRO ");
            System.out.println("[-------------------------------------]\n");
            System.out.println("Si desea salir escriba 'salir' en el campo del nombre");
            do {
                System.out.print("\n--> Introduce tu nombre: ");
                username = input.nextLine();
                if (username.equalsIgnoreCase("salir")){
                    Welcome();
                    break;
                } else if (databaseU.get(username) != null){
                    System.out.println("  <<Nombre de usuario ya usado>>");
                }else {
                    do {
                        System.out.print("\n--> Introduce tu contraseña (entre 8 y 12 caracteres): ");
                        password = input.nextLine();
                        if(password.length() < 7 | password.length() > 13){
                            System.out.println("                  <<Longitud incorrecta>>");
                        }
                    }while (password.length() < 7 | password.length() > 13);
                    if(!username.startsWith("¬")) {
                        System.out.print("\n--> Introduce tu apodo en juego: ");
                        nickname = input.nextLine();

                    }
                    user.setName(username);
                    user.setPassword(password);
                    user.setNick(nickname);
                break;
                }

            }while (databaseU.get(username) != null);

            // Implement your logic to save the user information
            // For example, you could create a new user object and store the information there
            if (username.startsWith("¬")){
                user.setUsertype(TUser.ADMIN);
                user.setRegisterNumber("0");

            } else{

                Random rand = new Random();  //lnnll
                StringBuilder sb = new StringBuilder();
                char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
                sb.append(letras[rand.nextInt(letras.length)]); // letra aleatoria
                sb.append(rand.nextInt(10)); // número aleatorio
                sb.append(rand.nextInt(10)); // número aleatorio
                sb.append(letras[rand.nextInt(letras.length)]); // letra aleatoria
                sb.append(letras[rand.nextInt(letras.length)]); // letra aleatoria
                String resultado = sb.toString();
                user.setRegisterNumber(resultado);
                user.setUsertype(TUser.CLIENT);

            }
            databaseU.put(username,user);
            System.out.println("\nRegistro completado!");
            System.out.println("Nombre de usuario: " + username);
            if(!Objects.equals(user.getRegisterNumber(), "0")) {
                System.out.println("Apodo: " + nickname);
            }
            System.out.println();
            System.out.println("<<Presione 'Enter' para continuar>>");
            nickname = input.nextLine();




        databaseManager.saveDatabaseU(databaseU);
            Welcome();


    }
    // Constructor


    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public Map<String, User> getDatabaseU() {
        return databaseU;
    }

    public void setDatabaseU(Map<String, User> databaseU) {
        this.databaseU = databaseU;
    }

    public void Welcome(){
        Welcome welcome = new Welcome();
        welcome.Welcome();

    }
}


