import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (valueToIndex.containsKey(complement)) {
                return new int[]{valueToIndex.get(complement), i};
            }
            valueToIndex.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] answer = twoSum(arr, target);
        System.out.println("Indices: [" + answer[0] + ", " + answer[1] + "]");
    }
}
