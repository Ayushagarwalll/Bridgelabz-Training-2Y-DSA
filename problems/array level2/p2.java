import java.util.*;
public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[3];
        double[] height = new double[3];
        for (int i = 0; i < 3; i++) { age[i] = sc.nextInt(); height[i] = sc.nextDouble(); }
        int y = 0; double t = height[0];
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[y]) y = i;
            if (height[i] > t) t = height[i];
        }
        System.out.println(age[y] + " " + t);
    }
}
