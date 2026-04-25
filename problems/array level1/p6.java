import java.util.*;
public class p6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] h = new double[11];
        double sum = 0;
        for (int i = 0; i < 11; i++) {
            h[i] = sc.nextDouble();
            sum += h[i];
        }
        System.out.println(sum / 11.0);
    }
}
