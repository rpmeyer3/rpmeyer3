import java.util.*;

public class Aaagmnrs {

    public String[] anagrams(String[] phrases) {
        List<String> list = new ArrayList<>();

        list.add(phrases[0]);

        for (int i = 1; i < phrases.length; i++) {
            String current = phrases[i];
            boolean removeCurrent =  false;
            for (String pp: list) {
                if (areAnagrams(pp,current)) {
                    removeCurrent = true;
                    break;
                }

            }
            if (!removeCurrent){
                list.add(current);
            }
        }
        return list.toArray(new String[0]);

    }

     boolean areAnagrams(String p1, String p2) {
        char[] part1 = toLowerCaseCharArrayStripSpaces(p1);
        char[] part2 = toLowerCaseCharArrayStripSpaces(p2);

        Arrays.sort(part1);
        Arrays.sort(part2);

        return Arrays.equals(part1, part2);
    }

    char[] toLowerCaseCharArrayStripSpaces(String s) {
        return s.toLowerCase().replaceAll("\\s", "").toCharArray();
    }
}
