import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> visited = new HashSet<>();

        for (int value : arr) {
            int needed = target - value;
            if (visited.contains(needed)) {
                return true;
            }
            visited.add(value);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        System.out.println("Pair exists for target " + target + ": " + hasPairWithSum(arr, target));
    }
}
