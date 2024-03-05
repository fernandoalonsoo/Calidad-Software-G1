import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class History implements Serializable {

    private List<Match> matches = new ArrayList<>();

    public void appendMatch(Match match){
        matches.add(match);

    }
    public List<Match> getMatches() {
        return matches;
    }
}



