import java.util.*;
public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) a[i] = sc.nextInt();
        for (int x : a) {
            if (x > 0) System.out.println(x + (x % 2 == 0 ? " is even" : " is odd"));
            else if (x < 0) System.out.println(x + " is negative");
            else System.out.println("0 is zero");
        }
        if (a[0] == a[4]) System.out.println("first and last are equal");
        else if (a[0] > a[4]) System.out.println("first is greater than last");
        else System.out.println("first is less than last");
    }
}
