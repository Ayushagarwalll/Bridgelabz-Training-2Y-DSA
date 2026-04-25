import java.util.*;
public class p4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] a = new double[10];
        int i = 0;
        while (true) {
            double x = sc.nextDouble();
            if (x <= 0 || i == 10) break;
            a[i++] = x;
        }
        double total = 0;
        for (int j = 0; j < i; j++) {
            total += a[j];
            System.out.print(a[j] + (j < i - 1 ? " " : ""));
        }
        System.out.println();
        System.out.println(total);
    }
}
