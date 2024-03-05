import java.io.Serializable;
import java.util.*;

public class ChallengeMenu  implements Serializable {
    private DatabaseManager databaseManager = new DatabaseManager();
    private Map<String, List<Challenge>> databaseP = new HashMap<>();
    private Map<String, Character> databaseC = new HashMap<>();
    private Map<String, User> databaseU = new HashMap<>();

    public User ChallengeMenu(User defiant) {
        Challenge challenge = new Challenge();
        databaseP = databaseManager.obtainDatabaseP();
        databaseU = databaseManager.obtainDatabaseU();
        databaseC = databaseManager.obtainDatabaseC();
        String username, goldBet;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Este es el menú de desafíos");
        System.out.println("     [---------------- LISTA DE USUARIOS -------------] ");
        Set<String> keyset = databaseU.keySet();

        for (String key : keyset) {
            User user = databaseU.get(key);
            if (user != null) {
                if (!user.getName().startsWith("¬")){
                    System.out.println("                 >Usuario: " + user.getName());
                    System.out.println("                 >Numero de registro: " + user.getRegisterNumber());
                    System.out.println("     ------------------------------------------------- ");
                }
            }
        }
        do {
            System.out.println("Escribe 'salir' para volver al menu");
            System.out.print("Escribe el nombre de usuario de la persona que quieras desafiar: ");
            username = scanner.nextLine();
            if (username.equalsIgnoreCase("salir")){
                return defiant;
            }else if (databaseU.get(username) == null) {
                System.out.println("<<Usuario no encontrado>>");
            }else if( databaseU.get(username).getName().startsWith("¬")) {
                System.out.println("<<Usuario no encontrado>>");
            }else if (Objects.equals(username, defiant.getName())) {
                System.out.println("<<No es posible autodesafiarse>>");
            }
        } while (databaseU.get(username) == null || Objects.equals(username, defiant.getName()) | databaseU.get(username).getName().startsWith("¬"));
        User defied = databaseU.get(username);
        String aux1 = defiant.getRegisterNumber();
        String aux2 = defied.getRegisterNumber();
        Character c1 = databaseC.get(aux1);
        Character c2 = databaseC.get(aux2);
        int maxBet = Math.min(c1.getGoldValue(), c2.getGoldValue());
        int gold = maxBet+1;
        do {
            System.out.println("¿Cuánto oro quieres apostar? Máximo: " + maxBet);
            goldBet = scanner.nextLine();
            try {
                gold = Integer.parseInt(goldBet);
                if (gold > maxBet || gold < 1){
                    System.out.println("número no valido");
                }
            }catch (Exception e){
                System.out.println("Caracter no numeral");
            }
        } while (gold > maxBet || gold< 1);
        challenge.setDefiant(defiant);
        challenge.setDefied(defied);
        challenge.setGold(gold);
        challenge.setValid(false);
        List<Challenge> challengeList = new ArrayList<>();
        if (databaseP.get(aux2) != null) {
            challengeList = databaseP.get(aux2);
            challengeList.add(0, challenge);
            databaseP.put(aux2, challengeList);
            databaseManager.saveDatabaseP(databaseP);
            System.out.println("Desafío correctamente enviado");
            goldBet = scanner.nextLine();
        } else{
            challengeList.add(0,challenge);
            databaseP.put(aux2, challengeList);
            databaseManager.saveDatabaseP(databaseP);
            System.out.println("Desafío correctamente enviado");
            goldBet = scanner.nextLine();
        }
        return defiant;
    }
}
