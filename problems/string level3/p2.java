import java.util.*;

public class p2 {
    static int lenNoLength(String s) {
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

    static char[] uniqueChars(String s) {
        int n = lenNoLength(s), k = 0;
        char[] temp = new char[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            boolean seen = false;
            for (int j = 0; j < i; j++) if (s.charAt(j) == ch) { seen = true; break; }
            if (!seen) temp[k++] = ch;
        }
        char[] out = new char[k];
        for (int i = 0; i < k; i++) out[i] = temp[i];
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println(Arrays.toString(uniqueChars(text)));
    }
}
