import java.util.*;
public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), c = 0, x = n;
        while (x != 0) { c++; x /= 10; }
        int[] d = new int[c], r = new int[c];
        for (int i = c - 1; i >= 0; i--) { d[i] = n % 10; n /= 10; }
        for (int i = 0; i < c; i++) r[i] = d[c - 1 - i];
        for (int v : r) System.out.print(v + " ");
    }
}
