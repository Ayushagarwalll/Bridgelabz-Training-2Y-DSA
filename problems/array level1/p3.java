import java.util.*;
public class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[10];
        for (int i = 1; i <= 10; i++) m[i - 1] = n * i;
        for (int i = 1; i <= 10; i++) System.out.println(n + " * " + i + " = " + m[i - 1]);
    }
}
