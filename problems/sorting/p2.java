import java.util.*;

public class p2 {
    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) ids[i] = sc.nextInt();
        insertionSort(ids);
        for (int i = 0; i < n; i++) System.out.print(ids[i] + (i + 1 < n ? " " : ""));
    }
}
