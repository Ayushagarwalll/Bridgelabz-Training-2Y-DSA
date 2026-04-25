import java.util.*;

public class p5 {
    static char[] uniqueChars(String s) {
        char[] temp = new char[s.length()];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean seen = false;
            for (int j = 0; j < i; j++) if (s.charAt(j) == ch) { seen = true; break; }
            if (!seen) temp[k++] = ch;
        }
        char[] out = new char[k];
        for (int i = 0; i < k; i++) out[i] = temp[i];
        return out;
    }

    static String[][] freqUsingUnique(String s) {
        int[] f = new int[256];
        for (int i = 0; i < s.length(); i++) f[s.charAt(i)]++;
        char[] u = uniqueChars(s);
        String[][] out = new String[u.length][2];
        for (int i = 0; i < u.length; i++) {
            out[i][0] = String.valueOf(u[i]);
            out[i][1] = String.valueOf(f[u[i]]);
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] t = freqUsingUnique(text);
        System.out.println("Char\tFreq");
        for (String[] r : t) System.out.println(r[0] + "\t" + r[1]);
    }
}
