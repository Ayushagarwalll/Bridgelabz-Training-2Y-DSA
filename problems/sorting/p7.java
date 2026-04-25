import java.util.*;

public class p7 {
    static int[] countingSortAges(int[] ages) {
        int min = 10, max = 18;
        int[] count = new int[max - min + 1];
        for (int x : ages) {
            if (x < min || x > max) return null;
            count[x - min]++;
        }
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
        int[] out = new int[ages.length];
        for (int i = ages.length - 1; i >= 0; i--) {
            int x = ages[i];
            out[count[x - min] - 1] = x;
            count[x - min]--;
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) ages[i] = sc.nextInt();
        int[] sorted = countingSortAges(ages);
        if (sorted == null) {
            System.out.println("Invalid age range");
            return;
        }
        for (int i = 0; i < n; i++) System.out.print(sorted[i] + (i + 1 < n ? " " : ""));
    }
}
