import java.io.Serializable;
import java.util.*;

public class Combat implements Serializable {
    private int rounds;
    private List<Round> roundList = new ArrayList<>();
    private State state;
    private int goldBet;




    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public List<Round> getRoundList() {
        return roundList;
    }

    public void setRoundList(List<Round> roundList) {
        this.roundList = roundList;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getGoldBet() {
        return goldBet;
    }

    public void setGoldBet(int goldBet) {
        this.goldBet = goldBet;
    }
}
