import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        Set<Integer> values = new HashSet<>();
        for (int value : arr) {
            values.add(value);
        }

        int best = 0;

        for (int value : values) {
            if (!values.contains(value - 1)) {
                int current = value;
                int length = 1;

                while (values.contains(current + 1)) {
                    current++;
                    length++;
                }

                best = Math.max(best, length);
            }
        }

        return best;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2, 2};
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(arr));
    }
}
