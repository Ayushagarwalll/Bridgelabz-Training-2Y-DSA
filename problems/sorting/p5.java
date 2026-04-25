import java.util.*;

public class p5 {
    static void quickSort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }

    static int partition(int[] a, int l, int r) {
        int pivot = a[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[r];
        a[r] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        quickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) System.out.print(a[i] + (i + 1 < n ? " " : ""));
    }
}
