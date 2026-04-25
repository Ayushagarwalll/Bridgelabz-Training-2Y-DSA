import java.util.*;

public class p1 {
    static int lenByCharAt(String s) {
        int c = 0;
        try {
            while (true) {
                s.charAt(c);
                c++;
            }
        } catch (RuntimeException e) {
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int user = lenByCharAt(s);
        int builtIn = s.length();
        System.out.println(user);
        System.out.println(builtIn);
    }
}
