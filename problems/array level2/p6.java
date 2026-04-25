import java.util.*;
public class p6 {
    static String bmiStatus(double b) { return b < 18.5 ? "Underweight" : b < 25 ? "Normal" : b < 30 ? "Overweight" : "Obese"; }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] w = new double[n], h = new double[n], bmi = new double[n];
        String[] s = new String[n];
        for (int i = 0; i < n; i++) { w[i] = sc.nextDouble(); h[i] = sc.nextDouble(); bmi[i] = w[i] / (h[i] * h[i]); s[i] = bmiStatus(bmi[i]); }
        for (int i = 0; i < n; i++) System.out.println(h[i] + " " + w[i] + " " + bmi[i] + " " + s[i]);
    }
}
