import java.util.Scanner;

public class MenuAdmin {


    public void MenuAdmin(User u) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n[-------------------------------------]");
            System.out.println("           MENU ADMINISTRADOR");
            System.out.println("[-------------------------------------]\n");
            System.out.println("1. Eliminar Administrador");
            System.out.println("2. Editar Personaje");
            System.out.println("3. Validar Desafío");
            System.out.println("4. Agregar Característica");
            System.out.println("5. Banear Usuario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1" -> {
                    u = deleteAdmin(u);//ok
                    if (u == null) {
                        Welcome welcome = new Welcome();
                        welcome.Welcome();
                    }
                }
                case "2" -> editCharacter(u);//ok
                case "3" -> validateChallenges(u);
                case "4" -> addFeature(u);//ok
                case "5" -> banUser();
                case "6" -> {
                    continuar = false;  //WARNING LINE
                    backAdmin();
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private User deleteAdmin(User u){
        DeleteAdmin deleteadmin = new DeleteAdmin();
        u = deleteadmin.DeleteAdmin(u);
        return u;
    }

    private void editCharacter(User u){
        EditCharacter editCharacter = new EditCharacter();
        editCharacter.EditCharacter(u);
    }

    private void validateChallenges(User u){
        ValidateChallenges validateChallenges = new ValidateChallenges();
        validateChallenges.ValidateChallenges(u);
    }
    private void addFeature(User u){
        AddFeature addFeature = new AddFeature();
        addFeature.AddFeature(u);
    }
    private void banUser(){
        UserManager userManager = new UserManager();
        userManager.UserManager();
    }

    //método para ir hacia atrás en el menu admin
    private void backAdmin(){
        Login login = new Login();
        login.Login();
    }




}

