import java.util.*;

public class Closet {
    public static String anywhere(String[] list) {
        Set<String> uniqueWords = new TreeSet<>();
        for (String s : list) {
            String[] words = s.split(" ");
            uniqueWords.addAll(Arrays.asList(words));
        }
        StringJoiner sj = new StringJoiner(" ");
        for (String word : uniqueWords) {
            sj.add(word);
        }
        return sj.toString();
    }
}
