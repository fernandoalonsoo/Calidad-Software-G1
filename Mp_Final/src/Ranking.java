
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Ranking {
    public List<Character> Ranking(List<Character> characters){
        if(characters.size()>1) {
           quickSort(characters, 0, characters.size() - 1);
        }
        return characters;
    }

    public static void quickSort(List<Character> list, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, left, right);
            quickSort(list, left, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, right);
        }
    }

    private static int partition(List<Character> list, int left, int right) {
        int pivotValue = list.get(right).getWins();
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (list.get(j).getWins() >= pivotValue) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, right);
        return i + 1;
    }
}
