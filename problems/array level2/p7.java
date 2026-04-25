import java.util.*;
public class p7 {
    static String bmiStatus(double b) { return b < 18.5 ? "Underweight" : b < 25 ? "Normal" : b < 30 ? "Overweight" : "Obese"; }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] p = new double[n][3];
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            p[i][0] = sc.nextDouble();
            p[i][1] = sc.nextDouble();
            while (p[i][0] < 0) p[i][0] = sc.nextDouble();
            while (p[i][1] < 0) p[i][1] = sc.nextDouble();
            p[i][2] = p[i][0] / (p[i][1] * p[i][1]);
            s[i] = bmiStatus(p[i][2]);
        }
        for (int i = 0; i < n; i++) System.out.println(p[i][1] + " " + p[i][0] + " " + p[i][2] + " " + s[i]);
    }
}
