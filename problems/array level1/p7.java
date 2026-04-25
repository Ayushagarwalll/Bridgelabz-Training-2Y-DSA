import java.util.*;
public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) { System.out.println("Not a natural number"); return; }
        int[] odd = new int[n / 2 + 1], even = new int[n / 2 + 1];
        int oi = 0, ei = 0;
        for (int i = 1; i <= n; i++) if (i % 2 == 0) even[ei++] = i; else odd[oi++] = i;
        for (int i = 0; i < oi; i++) System.out.print(odd[i] + (i < oi - 1 ? " " : "\n"));
        for (int i = 0; i < ei; i++) System.out.print(even[i] + (i < ei - 1 ? " " : "\n"));
    }
}
