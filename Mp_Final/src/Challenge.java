import java.io.Serializable;

public class Challenge implements Serializable {
    private int gold;
    private User defiant;
    private User defied;
    private boolean valid;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public User getDefiant() {
        return defiant;
    }

    public void setDefiant(User defiant) {
        this.defiant = defiant;
    }

    public User getDefied() {
        return defied;
    }

    public void setDefied(User defied) {
        this.defied = defied;
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
