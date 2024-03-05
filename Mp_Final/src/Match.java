import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Match implements Serializable {
    private Character defiant;
    private int goldBet;
    private int rounds;
    private boolean minionsLeft;
    private Character defied;
    private Character winner;
    private LocalDateTime date;

    public Character getDefiant() {
        return defiant;
    }

    public void setDefiant(Character defiant) {
        this.defiant = defiant;
    }

    public int getGoldBet() {
        return goldBet;
    }

    public void setGoldBet(int goldBet) {
        this.goldBet = goldBet;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isMinionsLeft() {
        return minionsLeft;
    }

    public void setMinionsLeft(boolean minionsLeft) {
        this.minionsLeft = minionsLeft;
    }

    public Character getDefied() {
        return defied;
    }

    public void setDefied(Character defied) {
        this.defied = defied;
    }

    public Character getWinner() {
        return winner;
    }

    public void setWinner(Character winner) {
        this.winner = winner;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
