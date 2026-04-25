import java.util.*;

public class p2 {
    static String subByCharAt(String s, int st, int en) {
        StringBuilder out = new StringBuilder();
        for (int i = st; i < en; i++) out.append(s.charAt(i));
        return out.toString();
    }

    static boolean eqByCharAt(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int st = sc.nextInt();
        int en = sc.nextInt();
        if (st < 0 || en > s.length() || st > en) {
            System.out.println("Invalid index");
            return;
        }
        String user = subByCharAt(s, st, en);
        String builtIn = s.substring(st, en);
        System.out.println(user);
        System.out.println(builtIn);
        System.out.println(eqByCharAt(user, builtIn));
    }
}
