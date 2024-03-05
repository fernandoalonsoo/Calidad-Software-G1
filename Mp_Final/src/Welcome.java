import java.util.Scanner;
public class Welcome {

    public void Welcome() {
        Scanner scanner = new Scanner(System.in);
        boolean b = true;

        do {
            System.out.println("\n[-------------------------------------]");
            System.out.println("             ¡BIENVENIDO!");
            System.out.println("[-------------------------------------]\n");
            System.out.println("1. Login");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.println("[-------------------------------------]\n");
            System.out.print("--> Escoja una opción: ");
            String input = scanner.nextLine();
            int numero = 0;
            try {
                numero = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("<<No has introducido un número entero válido>>");
            }
            switch (numero) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> {
                    System.out.println("\nSaliendo...");
                    b = false;
                }
                default -> System.out.println("Número incorrecto");
            }
        } while (b);  //Condiciona hasta que se meta un input valido
        scanner.close();
        System.exit(33);
    }
    private void login(){
        Login login = new Login();
        login.Login();
    }

    private void register(){
        Register register = new Register();
        register.Register();
    }

}
