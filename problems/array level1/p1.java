import java.util.*;
public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[10];
        for (int i = 0; i < age.length; i++) age[i] = sc.nextInt();
        for (int a : age) {
            if (a < 0) System.out.println("Invalid age");
            else if (a >= 18) System.out.println("The student with the age " + a + " can vote");
            else System.out.println("The student with the age " + a + " cannot vote");
        }
    }
}
