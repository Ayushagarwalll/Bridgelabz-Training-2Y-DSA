import java.util.*;
public class p8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) { System.out.println("Invalid number"); return; }
        int maxFactor = 10, count = 0;
        int[] f = new int[maxFactor];
        for (int i = 1; i <= n; i++) if (n % i == 0) {
            if (count == maxFactor) {
                maxFactor *= 2;
                int[] t = new int[maxFactor];
                for (int j = 0; j < count; j++) t[j] = f[j];
                f = t;
            }
            f[count++] = i;
        }
        for (int i = 0; i < count; i++) System.out.print(f[i] + (i < count - 1 ? " " : "\n"));
    }
}
