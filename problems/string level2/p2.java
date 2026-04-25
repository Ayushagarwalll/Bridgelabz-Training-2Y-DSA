import java.util.*;

public class p2 {
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

    static String[] splitByCharAt(String s) {
        int n = lenByCharAt(s), words = 0, i = 0;
        while (i < n) {
            while (i < n && s.charAt(i) == ' ') i++;
            if (i < n) words++;
            while (i < n && s.charAt(i) != ' ') i++;
        }
        int[] sp = new int[words + 1];
        String[] out = new String[words];
        i = 0;
        int k = 0;
        while (i < n && k < words) {
            while (i < n && s.charAt(i) == ' ') i++;
            int st = i;
            while (i < n && s.charAt(i) != ' ') i++;
            sp[k] = st;
            sp[k + 1] = i;
            out[k] = s.substring(sp[k], sp[k + 1]);
            k++;
        }
        return out;
    }

    static boolean same(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (!a[i].equals(b[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] user = splitByCharAt(text);
        String[] builtIn = text.trim().isEmpty() ? new String[0] : text.trim().split("\\s+");
        System.out.println(Arrays.toString(user));
        System.out.println(Arrays.toString(builtIn));
        System.out.println(same(user, builtIn));
    }
}
