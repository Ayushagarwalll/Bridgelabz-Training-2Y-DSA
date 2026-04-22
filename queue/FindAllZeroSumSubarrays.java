import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllZeroSumSubarrays {

    public static List<int[]> findAllZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumToIndices = new HashMap<>();

        int prefixSum = 0;
        sumToIndices.put(0, new ArrayList<>(List.of(-1)));

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (sumToIndices.containsKey(prefixSum)) {
                for (int startIndex : sumToIndices.get(prefixSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            sumToIndices.computeIfAbsent(prefixSum, key -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, 3, 1, -4};
        List<int[]> subarrays = findAllZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays (start, end):");
        for (int[] pair : subarrays) {
            System.out.println("[" + pair[0] + ", " + pair[1] + "]");
        }
    }
}
