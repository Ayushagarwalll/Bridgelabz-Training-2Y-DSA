import java.util.*;
public class p8 {
    static String grade(double p) { return p >= 80 ? "A" : p >= 70 ? "B" : p >= 60 ? "C" : p >= 50 ? "D" : p >= 40 ? "E" : "R"; }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[n][3];
        double[] p = new double[n];
        String[] g = new String[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = sc.nextInt();
                while (m[i][j] < 0) m[i][j] = sc.nextInt();
            }
            p[i] = (m[i][0] + m[i][1] + m[i][2]) / 3.0;
            g[i] = grade(p[i]);
        }
        for (int i = 0; i < n; i++) System.out.println(m[i][0] + " " + m[i][1] + " " + m[i][2] + " " + p[i] + " " + g[i]);
    }
}
