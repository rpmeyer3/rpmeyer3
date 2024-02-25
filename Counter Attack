import java.util.List;

public class CounterAttack {
    public int[] analyze(String str, List<String> words) {
        int[] result = new int[words.size()];

        String[] strWords = str.split("\\s+");

        for (int i = 0; i < words.size(); i++) {
            String wordToSearch = words.get(i);
            int count = 0;

            for (String strWord : strWords) {

                if (strWord.equalsIgnoreCase(wordToSearch)) {
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        CounterAttack counter = new CounterAttack();
        String str = "I love New York. This is another test that has nothing to do with New York.";
        List<String> words = List.of("This", "test", "string", "another");
        int[] counts = counter.analyze(str, words);

        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + ": " + counts[i]);
        }
    }
}
