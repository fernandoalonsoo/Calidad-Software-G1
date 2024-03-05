import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class Menu implements Serializable {
    private DatabaseManager databaseManager = new DatabaseManager();
    private Map<String, List<Challenge>> databaseP = new HashMap<>();
    private Map<String, Character> databaseC = new HashMap<>();
    private Map<String, User> databaseU = new HashMap<>();

    public void Menu(User u){
        databaseU = databaseManager.obtainDatabaseU();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean d;
        Challenge ch = new Challenge();
        List<Challenge> challengeList ;
        Character c;


        String forcedoption;
        int gold;
        List<Combat> combats = u.getResultados();
        boolean pendingResult;
        if (combats == null){
            pendingResult =false;
        }else {
            pendingResult = !combats.isEmpty();
        }
        databaseC = databaseManager.obtainDatabaseC();

        if (databaseC == null){
            System.out.println("\n <<Es obligatorio crear un persoanje si aún no tienes uno>> ");
            characterMenu(u);
        } else if (databaseC.get(u.getRegisterNumber()) == null ){
            System.out.println("\n <<Es obligatorio crear un persoanje si aún no tienes uno>> ");
            characterMenu(u);
        }else{

           databaseP = databaseManager.obtainDatabaseP();
            challengeList = databaseP.get(u.getRegisterNumber());
            gold = databaseC.get(u.getRegisterNumber()).getGoldValue();
            if (challengeList != null){
                if (challengeList.size() > 0) {
                    Challenge popup = challengeList.get(0);
                    int othergold = popup.getGold();
                    c = databaseC.get(u.getRegisterNumber());
                    d = !challengeList.isEmpty();  // si esta vacia True = False
                    if (d) {
                        for (int xx = 0 ; xx < challengeList.size(); xx++ ) {
                            if (challengeList.get(xx).isValid()) {
                                double redondeado = Math.round(othergold * 0.1);
                                System.out.println("========== Tienes un duelo pendiente ==========");
                                System.out.println("1. Aceptar");
                                System.out.println("2. Rechazar " + "(pierdes:" + (int) Math.round(redondeado) + ")");
                                forcedoption = scanner.nextLine();
                                switch (forcedoption) {
                                    case "1" -> {
                                        d = false;
                                        databaseP = databaseManager.obtainDatabaseP();
                                        challengeList = databaseP.get(u.getRegisterNumber());
                                        Challenge challenge = challengeList.get(xx);
                                        databaseP.put(u.getRegisterNumber(), challengeList);
                                        databaseManager.saveDatabaseP(databaseP);
                                        User udefiant = databaseU.get(challenge.getDefiant().getName());
                                        User udefied = databaseU.get(challenge.getDefied().getName());
                                        equipmentMenu(u, true);
                                        fight(udefiant, udefied, othergold);
                                    }
                                    case "2" -> {
                                        //probar el rechazar
                                        databaseP = databaseManager.obtainDatabaseP();
                                        challengeList = databaseP.get(u.getRegisterNumber());
                                        Challenge challenge = challengeList.get(xx);
                                        databaseP.put(u.getRegisterNumber(), challengeList);
                                        databaseManager.saveDatabaseP(databaseP);
                                        updateGold(c, popup, u,redondeado);
                                        d = false;
                                    }
                                    default -> System.out.println("Opción no válida");
                                }
                            }
                        }
                    }
                }
            }
            if (pendingResult) {
                while (pendingResult){
                    Combat c2 = combats.remove(0);
                    System.out.println("Tienes resultados pendientes");
                    String aux = scanner.nextLine();
                    pendingResult = !combats.isEmpty();
                    u.setResultados(combats);
                    databaseU.put(u.getName(),u);
                    databaseManager.saveDatabaseU(databaseU);
                    showresult(c2, u);
                }

            }
            while (!exit) {
                System.out.print("\n<><><><><><><><><><><><><><><><><><><>\n");
                System.out.println("\n[-------------------------------------]");
                System.out.println("                 MENU");
                System.out.println("[-------------------------------------]\n");
                System.out.println("0. Salir");
                System.out.println("1. Borrar cuenta");
                System.out.println("2. Menu de equipamiento");
                System.out.println("3. Menu de desafíos");
                System.out.println("4. Historial");
                System.out.println("5. Crear nuevo personaje (se borrara el actual)");
                System.out.println("6. Ranking");
                System.out.println("7. Normas");
                System.out.print("--> ");
                String option = scanner.nextLine();
                // personaje, challenge, result

                switch (option) {

                    case "1" -> u = deleteAccount(u); // ok
                    case "2" -> equipmentMenu(u, false); // ok
                    case "3" -> challengeMenu(u); // ok
                    case "4" -> showhistory(u); // ok
                    case "5" -> characterMenu(u); // ok
                    case "6" -> ranking(); //ok
                    case "7" -> rules(); //ok
                    case "0" -> {
                        exit = false;
                        login();

                    }
                    default -> System.out.println("Opción no válida, por favor intenta de nuevo.");

                }
            }
        }
    }



    private User deleteAccount(User cl){
        DeleteAccount deleteAccount = new DeleteAccount();
        cl = deleteAccount.DeleteAccount(cl);
        if (cl == null){
            Welcome welcome = new Welcome();
            welcome.Welcome();
        }
        return cl;
    }
    private void login(){
        Login log = new Login();
        log.Login();
    }

    private void equipmentMenu(User u, boolean a){
        EquipmentMenu equipmentMenu = new EquipmentMenu();
        equipmentMenu.EquipmentMenu(u,a);

    }

    private void challengeMenu(User u){
        ChallengeMenu challengeMenu = new ChallengeMenu();
        challengeMenu.ChallengeMenu(u);

    }
    private void showhistory(User u){
        ShowHistory showHistory = new ShowHistory();
        showHistory.ShowHistory(u);

    }
    private void characterMenu(User u){
        CharacterMenu characterMenu = new CharacterMenu();
        characterMenu.CharacterMenu(u);

    }
    private void ranking(){
        ShowRanking showRanking= new ShowRanking();
         showRanking.ShowRanking();


    }
    private void updateGold(Character c, Challenge ch,User u,double redondeado){
        c.setGoldValue(c.getGoldValue() - (int) redondeado);
        databaseC.get(u.getRegisterNumber());
        databaseC.put(u.getRegisterNumber(), c);
        databaseManager.saveDatabaseC(databaseC);
        Menu(u);
    }



    private void rules(){
        Rules rules = new Rules();
        rules.ShowRules();
    }


    private void fight(User defiant, User defied, int gold){
        Fight fight = new Fight();
        System.out.println("Pelea comenzada");
        fight.setFight(defiant,defied,gold);
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }


    public Map<String, Character> getDatabaseC() {
        return databaseC;
    }

    public void setDatabaseC(Map<String, Character> databaseC) {
        this.databaseC = databaseC;
    }


    public void showresult(Combat c2, User user){
        Result result = new Result();
        result.showResult(c2,user);


    }
}
