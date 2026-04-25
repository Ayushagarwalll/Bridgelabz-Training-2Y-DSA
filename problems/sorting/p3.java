import java.util.*;

public class p3 {
    static void mergeSort(double[] a, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }

    static void merge(double[] a, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        double[] left = new double[n1], right = new double[n2];
        for (int i = 0; i < n1; i++) left[i] = a[l + i];
        for (int j = 0; j < n2; j++) right[j] = a[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) a[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        while (i < n1) a[k++] = left[i++];
        while (j < n2) a[k++] = right[j++];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] prices = new double[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextDouble();
        mergeSort(prices, 0, n - 1);
        for (int i = 0; i < n; i++) System.out.print(prices[i] + (i + 1 < n ? " " : ""));
    }
}
