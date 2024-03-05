import java.io.Serializable;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class  ValidateChallenges implements Serializable {
    private DatabaseManager databaseManager;
    private Map<String, List<Challenge>> databaseP = new HashMap<>();
    private Map<String, Character> databaseC = new HashMap<>();


    public void ValidateChallenges(User u) {
        databaseManager = new DatabaseManager();
        databaseC = databaseManager.obtainDatabaseC();
        databaseP = databaseManager.obtainDatabaseP();
        System.out.println("\n          [-------------------------------------]");
        System.out.println("                       VALIDAR DESAFIO");
        System.out.println("          [-------------------------------------]\n");
        System.out.println("     [---------------- LISTA DE DESAFIOS -------------] ");

        Set<String> keyset = databaseP.keySet();

        for (String key : keyset) {
            List<Challenge> ch = databaseP.get(key);
            System.out.println("   Número de registro:" + key);
            if (ch.isEmpty()) {
                System.out.println("                 >El usuario no tiene desafíos pendientes");
                System.out.println("     ------------------------------------------------- ");
            } else{
                for (int k = 0; k < ch.size(); k++) {
                    if(!ch.get(k).isValid()) {
                        System.out.println("                 -Numero de desafío: " + k);
                        System.out.println("                 >Desafiante: " + ch.get(k).getDefiant().getName());
                        System.out.println("                 >Desafiado: " + ch.get(k).getDefied().getName());
                        System.out.println("                 >Oro apostado: " + ch.get(k).getGold());
                        System.out.println("     ------------------------------------------------- ");
                    }else{
                        System.out.println("                 -Numero de desafío: " + k);
                        System.out.println("                 -Desafío validado");
                        System.out.println("     ------------------------------------------------- ");
                    }
                }
            }
        }

        //Pedimos el numeor de registro y numero de desafío a validar.
        Scanner scanner = new Scanner(System.in);
        int chIndex = -1;
        String numReg = "a";
        while (databaseP.get(numReg)== null || databaseP.get(numReg).isEmpty()) {
            System.out.println("Escoge el número de registro del usuario deseado");
            System.out.print("'salir' para salir: ");
            System.out.print("No se puede escoger un número de registro de un usuario sin desafíos: ");
            numReg = scanner.nextLine();
            if (numReg.equalsIgnoreCase("salir")) {
                menuAdmin(u);
            }else if (databaseP.get(numReg)== null || databaseP.get(numReg).isEmpty()){
               System.out.println("Número de registro erroneo");
            }
        }
        String aux;
        List<Challenge> cc = databaseP.get(numReg);
        while ((chIndex >= cc.size() || chIndex < 0) || cc.get(chIndex).isValid()) {
            System.out.println("Seleccione el número de desafío a validar");
            System.out.println("Escriba 'volver' para volver a escoger usuario:");
            aux = scanner.nextLine();
            if (aux.equalsIgnoreCase("volver")){
                ValidateChallenges(u);
            }
            try {
                chIndex = Integer.parseInt(aux);
                if (chIndex >= cc.size() || chIndex < 0 || cc.get(chIndex).isValid()) {
                    System.out.println("Introduzca un número válido");
                }
            }catch (Exception e){
                System.out.println("Introduzca un número");
            }
        }

        //me elimina o me valida un desafío
        String op = "a";
        do {
            System.out.println("¿Qué operación desea realizar?");
            System.out.println("1. Validar");
            System.out.println("2. Eliminar");
            op = scanner.nextLine();
            switch (op) {
                case "1" -> {
                    System.out.println("El desafío " + chIndex + "ha sido validado correctamente.");
                    cc.get(chIndex).setValid(true);
                    System.out.println("Ahora debe escoger las modificaciones");

                    User u1 = cc.get(chIndex).getDefied();
                    User u2 = cc.get(chIndex).getDefiant();

                    Character char1 = databaseC.get(u1.getRegisterNumber());
                    Character char2 = databaseC.get(u2.getRegisterNumber());

                    List<Modifiers> listmod = char1.getModifiersList();
                    List<Modifiers> listmod2 = char2.getModifiersList();
                    int j = 0;
                    System.out.println("Aqui se muestran los modificadores del desafiado");
                    int opcion;
                    String opt = "a";
                    boolean end = false;
                    do {
                        opcion = -1;
                        for (int i = 0; i < listmod.size(); i++) {
                            System.out.println("\n[-------------------------------------]");
                            System.out.println("Numero de modificador: " + i);
                            System.out.println("Nombre del modificador: " + listmod.get(i).getName());
                            System.out.println("Valor del modificador: " + listmod.get(i).getValue());
                            if (listmod.get(i).isBuff()){
                                System.out.println("Fortaleza");
                            }else{
                                System.out.println("Debilidad");
                            }
                            j = i + 1;
                        }
                        System.out.println("[-------------------------------------]");
                        while (opcion < 0 || opcion >= j) {
                            System.out.println("Por favor, introduzca el número de modificador");
                            System.out.println("Escriba 'salir' para ir a los modificadores del desafiado");
                            try {
                                opt = scanner.nextLine();
                                if (opt.equalsIgnoreCase("salir")) {
                                    end = true;
                                    break;
                                }
                                opcion = Integer.parseInt(opt);
                                if (opcion < 0 || opcion >= j) {
                                    System.out.println("Introduzca un número válido");
                                } else {
                                    if (listmod.get(opcion).isActive()) {
                                        listmod.get(opcion).setActive(false);
                                        System.out.println("El modificador " + listmod.get(opcion).getName() + " ahora está desactivado");
                                    }else{
                                        listmod.get(opcion).setActive(true);
                                        System.out.println("El modificador " + listmod.get(opcion).getName() + " ahora está activado");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Entrada inválida. Introduzca un número.");
                            }
                        }
                    } while (!end);
                    System.out.println("Aqui se muestran los modificadores del desafiante");


                    end = false;
                    do {
                        opcion = -1;
                        for (int i = 0; i < listmod2.size(); i++) {
                            System.out.println("\n[-------------------------------------]");
                            System.out.println("Numero de modificador: " + i);
                            System.out.println("Nombre del modificador: " + listmod2.get(i).getName());
                            System.out.println("Valor del modificador: " + listmod2.get(i).getValue());
                            if (listmod2.get(i).isBuff()){
                                System.out.println("Fortaleza");
                            }else{
                                System.out.println("Debilidad");
                            }
                        }
                        System.out.println("[-------------------------------------]");
                        while (opcion < 0 || opcion >= j) {
                            System.out.println("Por favor, introduzca el número de modificador");
                            System.out.println("Escriba 'salir' para terminar ");
                            try {
                                opt = scanner.nextLine();
                                if (opt.equalsIgnoreCase("salir")) {
                                    end = true;
                                    break;
                                }
                                opcion = Integer.parseInt(opt);
                                if (opcion < 0 || opcion >= j) {
                                    System.out.println("Introduzca un número válido");
                                } else {
                                    if (listmod2.get(opcion).isActive()) {
                                        listmod2.get(opcion).setActive(false);
                                        System.out.println("El modificador " + listmod2.get(opcion).getName() + " ahora está desactivado");
                                    } else {
                                        listmod2.get(opcion).setActive(true);
                                        System.out.println("El modificador " + listmod2.get(opcion).getName() + " ahora está activado");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Entrada inválida. Introduzca un número.");
                            }
                        }
                    }while (!end);
                    System.out.println("Modificadores activados correctamente");
                    char1.setModifierList(listmod);
                    char2.setModifierList(listmod2);


                    databaseC.put(u1.getRegisterNumber(), char1);
                    databaseC.put(u2.getRegisterNumber(), char2);
                    databaseManager.saveDatabaseC(databaseC);
                }
                case "2" -> {
                    System.out.println("El desafío " + chIndex + " ha sido eliminado correctamente.");
                    cc.remove(chIndex);


                }
                default -> System.out.println("Opción inválida");
            }
        }while (!op.equals("1") && !op.equals("2")) ;

        databaseP.put(numReg, cc);
        databaseManager.saveDatabaseP(databaseP);
    }

    private void menuAdmin(User u){
        MenuAdmin menuAdmin = new MenuAdmin();
        menuAdmin.MenuAdmin(u);
    }
}


