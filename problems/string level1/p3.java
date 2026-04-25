import java.util.*;

public class p3 {
    static char[] charsByLoop(String s) {
        char[] a = new char[s.length()];
        for (int i = 0; i < s.length(); i++) a[i] = s.charAt(i);
        return a;
    }

    static boolean same(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] user = charsByLoop(s);
        char[] builtIn = s.toCharArray();
        System.out.println(Arrays.toString(user));
        System.out.println(Arrays.toString(builtIn));
        System.out.println(same(user, builtIn));
    }
}
