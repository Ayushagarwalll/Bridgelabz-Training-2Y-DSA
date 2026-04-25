import java.util.*;

public class p1 {
    static String status(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 40.0) return "Overweight";
        return "Obese";
    }

    static String[][] bmiTable(double[][] hw) {
        String[][] out = new String[hw.length][4];
        for (int i = 0; i < hw.length; i++) {
            double w = hw[i][0], hCm = hw[i][1], hM = hCm / 100.0;
            double bmi = w / (hM * hM);
            out[i][0] = String.valueOf(hCm);
            out[i][1] = String.valueOf(w);
            out[i][2] = String.valueOf(Math.round(bmi * 100.0) / 100.0);
            out[i][3] = status(bmi);
        }
        return out;
    }

    static void show(String[][] t) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (String[] r : t) System.out.println(r[0] + "\t" + r[1] + "\t" + r[2] + "\t" + r[3]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hw = new double[10][2];
        for (int i = 0; i < 10; i++) {
            hw[i][0] = sc.nextDouble();
            hw[i][1] = sc.nextDouble();
        }
        show(bmiTable(hw));
    }
}
