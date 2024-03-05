import java.util.ArrayList;
import java.util.List;

public class Demon extends Minion{
    private String pact;
    private List<Minion> minionList = new ArrayList<>();

    public String getPact() {
        return pact;
    }

    public void setPact(String pact) {
        this.pact = pact;
    }

    public List<Minion> getMinionList() {
        return minionList;
    }

    public void setMinionList(List<Minion> minionList) {
        this.minionList = minionList;
    }
}
