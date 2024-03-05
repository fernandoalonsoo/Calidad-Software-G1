import javax.swing.undo.CannotUndoException;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Fight implements Serializable, Cloneable {


    private Round roundFight = new Round();
    private Combat combat = new Combat();
    private DatabaseManager databaseManager = new DatabaseManager();
    private Map<String, Character> databaseC = new HashMap<>();
    private Map<String, History> databaseH = new HashMap<>();
    private Map<String, User> databaseU = new HashMap<>();



    // Implementar luego
    public void Fight(Fighter defiant, Fighter defied, int gold, User udefiant, User udefied) {

        Random random = new Random();
        List<Integer> resultado = new ArrayList<>();
        int attackAnt, attackEd, defAnt, defEd;
        int hpAnt = defiant.getFighterHP();
        int hpEd = defied.getFighterHP();
        int rondas = combat.getRounds();
        rondas += 1;
        combat.setRounds(rondas);
        Character pdefiant = databaseC.get(udefiant.getRegisterNumber());

        Character pdefied = databaseC.get(udefied.getRegisterNumber());

        // Defiant
        resultado = RoundBalance(defiant, random);

        attackAnt = resultado.get(0);
        defAnt = resultado.get(1);

        // Defied

        resultado = RoundBalance(defied, random);


        attackEd = resultado.get(0);
        defEd = resultado.get(1);

        List<Integer> list = new ArrayList<>(2);
        if (attackAnt >= defEd){
            if (defied.getMinionHP() <= 0) {
                hpEd -= 1;

            }else{
                defied.setMinionHP(defied.getMinionHP()-1);
            }
            list.add(0,1);
        }else{
            list.add(0,0);
        }
        if (attackEd >= defAnt){
            if (defiant.getMinionHP() <= 0) {
                hpAnt -= 1;
            }else{
                defiant.setMinionHP(defiant.getMinionHP()-1);
            }
            list.add(1,1);
        }else {
            list.add(1, 0);
        }

        if (defiant.getType() == TCharacter.VAMPIRE && list.get(0) > 0 ){
            int q =  defiant.getTypeAttack();
            defiant.setTypeAttack(q+4);


        }
        if (defied.getType() == TCharacter.VAMPIRE && list.get(1) > 0 ){
            int q =  defied.getTypeAttack();
            defied.setTypeAttack(q+4);


        }








        Round rondaguardada = new Round();
        Fighter antaux = new Fighter();
        Fighter edaux = new Fighter();


        defiant.setFighterHP(hpAnt);
        defied.setFighterHP(hpEd);

        antaux.setMinionHP(defiant.getMinionHP());
        antaux.setFighterHP(defiant.getFighterHP());
        antaux.setName(defiant.getName());

        edaux.setMinionHP(defied.getMinionHP());
        edaux.setFighterHP(defied.getFighterHP());
        edaux.setName(defied.getName());





        rondaguardada.setDamageDealt(list);
        rondaguardada.setDefiantInfo(antaux);
        rondaguardada.setDefiedInfo(edaux);
        List<Round> listarondas = combat.getRoundList();
        listarondas.add(rondaguardada);
        combat.setRoundList(listarondas);
        combat.setGoldBet(gold);




        // Comprobacion de final de partida

        if (hpAnt == 0 || hpEd == 0){
            if (hpAnt == 0 && hpEd == 0) {
                endCombat(combat, State.DRAW, udefiant,udefied);
            }
            else if (hpAnt == 0){
                int oroperd = pdefiant.getGoldValue();
                oroperd -= gold;
                pdefiant.setGoldValue(oroperd);
                int orogan = pdefied.getGoldValue();
                orogan += gold;
                pdefied.setGoldValue(orogan);
                endCombat(combat, State.VDEFIED, udefiant, udefied );

            }
            else {
                int orogan = pdefiant.getGoldValue();
                orogan -= gold;
                pdefiant.setGoldValue(orogan);
                int oroperd = pdefied.getGoldValue();
                oroperd += gold;
                pdefied.setGoldValue(oroperd);
                endCombat(combat, State.VDEFIANT, udefiant, udefied);

            }
        }

        nextFight(defiant, defied, gold, udefiant, udefied);


    }

    public void setFight(User udefiant, User udefied, int gold){
        databaseC = databaseManager.obtainDatabaseC();
        Character pdefiant = databaseC.get(udefiant.getRegisterNumber());
        Character pdefied = databaseC.get(udefied.getRegisterNumber());

        Fighter defiant = new Fighter();
        Fighter defied = new Fighter();

        defiant.setName(pdefiant.getName());
        defiant.setType(pdefiant.getType());
        defiant.setDescription(pdefiant.getDescription());
        defiant.sethP(pdefiant.gethP());
        defiant.setWeaponSet(pdefiant.getWeaponSet());
        defiant.setArmorSet(pdefiant.getArmorSet());
        defiant.setPower(pdefiant.getPower());
        defiant.setMinionMap(pdefiant.getMinionMap());
        defiant.setModifierList(pdefiant.getModifiersList());
        defiant.setSpecialAbility(pdefiant.getSpecialAbility());
        defiant.setWins(pdefiant.getWins());
        defiant.setGoldValue(pdefiant.getGoldValue());
        defiant.setFighting(true);
        defiant.setFighterHP(defiant.gethP());

        defied.setName(pdefied.getName());
        defied.setType(pdefied.getType());
        defied.setDescription(pdefied.getDescription());
        defied.sethP(pdefied.gethP());
        defied.setWeaponSet(pdefied.getWeaponSet());
        defied.setArmorSet(pdefied.getArmorSet());
        defied.setPower(pdefied.getPower());
        defied.setMinionMap(pdefied.getMinionMap());
        defied.setModifierList(pdefied.getModifiersList());
        defied.setSpecialAbility(pdefied.getSpecialAbility());
        defied.setWins(pdefied.getWins());
        defied.setGoldValue(pdefied.getGoldValue());
        defied.setFighting(true);
        defied.setFighterHP(defied.gethP());

        fighter(defiant);
        fighter(defied);
        Fight(defiant,defied,gold, udefiant, udefied);

    }

    private List<Integer> RoundBalance(Fighter f, Random random){
        int exitosA = 0;
        int exitosD = 0;
        List<Integer> listaresult = new ArrayList<>();
        for (int i = 0; i < f.getAttackPower(); i++) {
            if (random.nextInt(1, 7) >= 5) {
                exitosA += 1;
            }
        }
        for (int x = 0 ; x < f.getDefensePower(); x++){
            if (random.nextInt(1, 7) >= 5) {
                exitosD += 1;
            }
        }
        listaresult.add(exitosA);
        listaresult.add(exitosD);

       return listaresult;
    }


    private void nextFight(Fighter defiant, Fighter defied, int gold, User udefiant, User udefied) {
        Fight(defiant, defied, gold, udefiant, udefied);
    }
    private void endCombat(Combat combat, State state, User udefiant, User udefied){
         databaseH = databaseManager.obtainDatabaseH();
         databaseU = databaseManager.obtainDatabaseU();
         History history = databaseH.get(udefiant.getRegisterNumber());
         History history2 = databaseH.get(udefied.getRegisterNumber());
         Match nuevapartida = new Match();
         Character perAnt = databaseC.get(udefiant.getRegisterNumber());
         Character perEd = databaseC.get(udefied.getRegisterNumber());
         combat.setState(state);
         List<Round> rondas= combat.getRoundList();
         Round rondafinal = rondas.get(rondas.size()-1);
         List<Combat> listacombates = new ArrayList<>();


         LocalDateTime date = LocalDateTime.now();
         nuevapartida.setDefiant(perAnt);
         nuevapartida.setDefied(perEd);
         nuevapartida.setRounds(combat.getRounds());


         switch (state){
             case VDEFIANT -> {
                 nuevapartida.setWinner(perAnt);
                 perAnt.setGoldValue(perAnt.getGoldValue() + combat.getGoldBet());
                 perEd.setGoldValue(perEd.getGoldValue() - combat.getGoldBet());


                 nuevapartida.setMinionsLeft(rondafinal.getDefiantInfo().getFighterHP() - rondafinal.getDefiantInfo().getMinionHP() > 0);

             }
             case VDEFIED -> {
                 nuevapartida.setWinner(perEd);
                 perEd.setGoldValue(perEd.getGoldValue() + combat.getGoldBet());
                 perAnt.setGoldValue(perAnt.getGoldValue() - combat.getGoldBet());

                 nuevapartida.setMinionsLeft((rondafinal.getDefiedInfo().getFighterHP() - rondafinal.getDefiedInfo().getMinionHP()) > 0);
             }
             case DRAW -> {
                 nuevapartida.setWinner(null);
                 nuevapartida.setMinionsLeft(false);
             }
             default -> throw new IllegalStateException("Unexpected value: " + state);
         }
         nuevapartida.setGoldBet(combat.getGoldBet());
         nuevapartida.setDate(date);
         if (history == null){
             history = new History();
         }
         history.appendMatch(nuevapartida);
        if (history2 == null){
            history2 = new History();
        }
         history2.appendMatch(nuevapartida);

         databaseH.replace(udefiant.getRegisterNumber() , history);
         databaseH.replace(udefied.getRegisterNumber() , history2);
         databaseManager.saveDatabaseH(databaseH);

         databaseC.replace(udefiant.getRegisterNumber(),perAnt);
         databaseC.replace(udefied.getRegisterNumber(),perEd);
         databaseManager.saveDatabaseC(databaseC);

         Scanner scanner = new Scanner(System.in);
         System.out.println("Combate terminado");
         String aux = scanner.nextLine();
         listacombates = udefiant.getResultados();
         listacombates.add(combat);
         udefiant.setResultados(listacombates);
         databaseU.replace(udefiant.getName(), udefiant);
         databaseManager.saveDatabaseU(databaseU);
         result(combat, udefied);




    }

    public Round getRoundFight() {
        return roundFight;
    }

    public void setRoundFight(Round roundFight) {
        this.roundFight = roundFight;
    }

    public Combat getCombat() {
        return combat;
    }

    public void setCombat(Combat combat) {
        this.combat = combat;
    }


    public void fighter(Fighter f) {
        Fighter fighter = new Fighter();
        fighter.Fighter(f);

    }
    public void result(Combat c, User user){
        Result result = new Result();
        result.showResult(c,user);
    }

}
