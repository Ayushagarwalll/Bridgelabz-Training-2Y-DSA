import java.util.*;

public class p1 {
    static boolean eqByCharAt(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        boolean user = eqByCharAt(s1, s2);
        boolean builtIn = s1.equals(s2);
        System.out.println(user);
        System.out.println(builtIn);
        System.out.println(user == builtIn);
    }
}
