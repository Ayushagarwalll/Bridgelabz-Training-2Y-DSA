import java.util.*;

public class p4 {
    static String[][] freqTable(String s) {
        int[] f = new int[256];
        boolean[] seen = new boolean[256];
        for (int i = 0; i < s.length(); i++) f[s.charAt(i)]++;
        int rows = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (!seen[c]) { seen[c] = true; rows++; }
        }
        String[][] out = new String[rows][2];
        Arrays.fill(seen, false);
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (!seen[c]) {
                seen[c] = true;
                out[k][0] = String.valueOf((char) c);
                out[k][1] = String.valueOf(f[c]);
                k++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] t = freqTable(text);
        System.out.println("Char\tFreq");
        for (String[] r : t) System.out.println(r[0] + "\t" + r[1]);
    }
}
