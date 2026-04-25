import java.util.*;

public class p6 {
    static String[] freqNested(String text) {
        char[] a = text.toCharArray();
        int[] f = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '\0') continue;
            f[i] = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    f[i]++;
                    a[j] = '\0';
                }
            }
        }
        int rows = 0;
        for (int i = 0; i < a.length; i++) if (a[i] != '\0') rows++;
        String[] out = new String[rows];
        int k = 0;
        for (int i = 0; i < a.length; i++) if (a[i] != '\0') out[k++] = a[i] + " : " + f[i];
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] out = freqNested(text);
        for (String s : out) System.out.println(s);
    }
}
