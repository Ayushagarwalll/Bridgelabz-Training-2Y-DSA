import java.util.*;

public class p10 {
    static int[][] randomPCM(int n) {
        int[][] m = new int[n][3];
        for (int i = 0; i < n; i++) for (int j = 0; j < 3; j++) m[i][j] = 10 + (int) (Math.random() * 90);
        return m;
    }

    static double[][] calc(int[][] pcm) {
        double[][] r = new double[pcm.length][3];
        for (int i = 0; i < pcm.length; i++) {
            double total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double avg = total / 3.0;
            double per = avg;
            r[i][0] = Math.round(total * 100.0) / 100.0;
            r[i][1] = Math.round(avg * 100.0) / 100.0;
            r[i][2] = Math.round(per * 100.0) / 100.0;
        }
        return r;
    }

    static String[][] grades(double[][] r) {
        String[][] g = new String[r.length][1];
        for (int i = 0; i < r.length; i++) {
            double p = r[i][2];
            g[i][0] = p >= 80 ? "A" : p >= 70 ? "B" : p >= 60 ? "C" : p >= 50 ? "D" : p >= 40 ? "E" : "R";
        }
        return g;
    }

    static void show(int[][] pcm, double[][] r, String[][] g) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\tPer\tGrade");
        for (int i = 0; i < pcm.length; i++) {
            System.out.println(pcm[i][0] + "\t" + pcm[i][1] + "\t" + pcm[i][2] + "\t" + r[i][0] + "\t" + r[i][1] + "\t" + r[i][2] + "\t" + g[i][0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] pcm = randomPCM(n);
        double[][] r = calc(pcm);
        String[][] g = grades(r);
        show(pcm, r, g);
    }
}
