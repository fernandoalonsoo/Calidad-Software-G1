import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Round implements Serializable {
    private Fighter defiantInfo;
    private Fighter defiedInfo;
    private List<Integer> damageDealt = new ArrayList<>(2);



    public Fighter getDefiantInfo() {
        return defiantInfo;
    }

    public void setDefiantInfo(Fighter defiantInfo) {
        this.defiantInfo = defiantInfo;
    }

    public Fighter getDefiedInfo() {
        return defiedInfo;
    }

    public void setDefiedInfo(Fighter defiedInfo) {
        this.defiedInfo = defiedInfo;
    }

    public List<Integer> getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(List<Integer> damageDealt) {
        this.damageDealt = damageDealt;
    }
}
