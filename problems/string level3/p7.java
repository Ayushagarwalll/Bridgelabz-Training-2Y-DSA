import java.util.*;

public class p7 {
    static boolean isPalTwoPointer(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    static boolean isPalRec(String s, int i, int j) {
        if (i >= j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return isPalRec(s, i + 1, j - 1);
    }

    static char[] reverseByCharAt(String s) {
        char[] r = new char[s.length()];
        for (int i = 0; i < s.length(); i++) r[i] = s.charAt(s.length() - 1 - i);
        return r;
    }

    static boolean isPalArray(String s) {
        char[] a = s.toCharArray(), r = reverseByCharAt(s);
        if (a.length != r.length) return false;
        for (int i = 0; i < a.length; i++) if (a[i] != r[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println(isPalTwoPointer(text));
        System.out.println(isPalRec(text, 0, text.length() - 1));
        System.out.println(isPalArray(text));
    }
}
