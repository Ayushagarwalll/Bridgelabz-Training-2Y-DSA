import java.util.*;

public class p7 {
    static int[] trimBounds(String s) {
        int st = 0, en = s.length() - 1;
        while (st < s.length() && s.charAt(st) == ' ') st++;
        while (en >= st && s.charAt(en) == ' ') en--;
        return new int[] {st, en + 1};
    }

    static String subByCharAt(String s, int st, int en) {
        StringBuilder out = new StringBuilder();
        for (int i = st; i < en; i++) out.append(s.charAt(i));
        return out.toString();
    }

    static boolean same(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] b = trimBounds(text);
        String user = subByCharAt(text, b[0], b[1]);
        String builtIn = text.trim();
        System.out.println(user);
        System.out.println(builtIn);
        System.out.println(same(user, builtIn));
    }
}
