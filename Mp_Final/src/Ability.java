import java.io.Serializable;
import java.util.Random;

public class Ability implements Serializable {
    private  TAbility type;
    private int defense;
    private int attack;
    private int specialValue;

    public TAbility getType() {
        return type;
    }

    public void setType(TCharacter type) {
        Random rand =new Random();
        if (type == TCharacter.VAMPIRE){
            this.type = TAbility.DISCIPLINE;
            setSpecialValue(rand.nextInt(0,4));
        } else if (type == TCharacter.WEREWOLF) {
            this.type = TAbility.GIFT;
            setSpecialValue(rand.nextInt(0,4));
        }else{
            this.type = TAbility.TALENT;
            setSpecialValue(0);
        }
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpecialValue() {
        return specialValue;
    }

    public void setSpecialValue(int specialValue) {
        this.specialValue = specialValue;
    }

}
