import java.io.Serializable;
import java.util.*;


public class UserManager implements Serializable {
private DatabaseManager databaseManager = new DatabaseManager();
private Map<String, User> databaseU = new HashMap<>();


   public void UserManager() {
       databaseU = databaseManager.obtainDatabaseU();
       boolean salir = false;
       Scanner scanner = new Scanner(System.in);
       while (!salir) {
           System.out.println("\n--- Menú de Baneo de Usuarios ---");
           System.out.println("1. Mostrar todos los usuarios");
           System.out.println("2. Banear un usuario");
           System.out.println("3. Desbanear un usuario");
           System.out.println("4. Salir");
           System.out.print("Ingrese la opción deseada: ");
           String opcion = scanner.nextLine();
           //numero de registro distitno de 0
           switch (opcion) {
               case "1" -> {
                   // Mostrar todos los usuarios
                   System.out.println("\n--- Lista de Usuarios ---");
                   for (User u : databaseU.values()) {

                       System.out.println("--------------------------------");
                       System.out.println("Nombre de usuario: " + u.getName() + " ---");
                       if (u.getName().startsWith("¬")) {
                           System.out.println("Usuario administrador, no se puede banear");
                       } else {
                           if (u.isBanned()) {
                               System.out.println("--> Este usuario se encuentra baneado");
                           } else {
                               System.out.println("--> Este usuario no se encuentra baneado");
                           }
                       }
                   }
               }

               case "2" -> {

                   System.out.println("---  Banear usuario ---");
                   System.out.print("Introduce el nombre del usuario a banear--> ");
                   String codeUser = scanner.nextLine();
                   if (!codeUser.startsWith("¬")) {
                        User u = databaseU.get(codeUser);
                        if ( u != null) {
                               if (u.isBanned()) {
                                   System.out.println("El usuario ya está baneado");
                                   databaseU.replace(codeUser, u);

                               } else {
                                   u.setBanned(true);
                                   databaseU.replace(codeUser, u);
                                   System.out.println("Usuario baneado correctamente");
                               }
                           } else {
                               System.out.println("El usuario no existe");
                        }
                   }else{
                       System.out.println("Usuario administrador");
                   }

               }
               case "3" -> {
                   System.out.println("---  Desbanear usuario ---");
                   System.out.print("Introduce el nombre del usuario a desbanear--> ");
                   String codeUser = scanner.nextLine();
                   if (!codeUser.startsWith("¬")) {
                       User u = databaseU.get(codeUser);
                       if ( u != null) {
                           if (!u.isBanned()) {
                               System.out.println("El usuario no está baneado");
                               databaseU.replace(codeUser, u);

                           } else {
                               u.setBanned(false);
                               databaseU.replace(codeUser, u);
                               System.out.println("Usuario desbaneado correctamente");
                           }
                       } else {
                           System.out.println("El usuario no existe");
                       }
                   }else{
                       System.out.println("Usuario administrador");
                   }

               }
               case "4" -> salir = true;
               default -> System.out.println("Número no válido");
           }

       }
       databaseManager.saveDatabaseU(databaseU);
   }




}






