import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringCuts {
    public String[] filter(List<String> list, int minLength) {
        Set<String> uniqueStrings = new HashSet<>();

        List<String> filteredList = new ArrayList<>();

        for (String str : list) {
            if (str.length() >= minLength && !uniqueStrings.contains(str)) {
                uniqueStrings.add(str);
                filteredList.add(str);
            }
        }

        // Convert the filteredList to an array and return it
        String[] result = new String[filteredList.size()];
        return filteredList.toArray(result);
    }
}
