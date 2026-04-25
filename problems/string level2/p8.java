import java.util.*;

public class p8 {
    static int[] randomAges(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = 10 + (int) (Math.random() * 90);
        return a;
    }

    static String[][] voteTable(int[] ages) {
        String[][] t = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            t[i][0] = String.valueOf(ages[i]);
            t[i][1] = String.valueOf(ages[i] >= 18 && ages[i] >= 0);
        }
        return t;
    }

    static void show(String[][] t) {
        System.out.println("Age\tCanVote");
        for (String[] row : t) System.out.println(row[0] + "\t" + row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        show(voteTable(randomAges(n)));
    }
}
