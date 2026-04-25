import java.util.*;
public class p9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) m[i][j] = sc.nextInt();
        int[] a = new int[r * c];
        int k = 0;
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) a[k++] = m[i][j];
        for (int x : a) System.out.print(x + " ");
    }
}
