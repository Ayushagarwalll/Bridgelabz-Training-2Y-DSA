import java.util.*;

public class p4 {
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
        String[] out = new String[words];
        i = 0;
        int k = 0;
        while (i < n && k < words) {
            while (i < n && s.charAt(i) == ' ') i++;
            int st = i;
            while (i < n && s.charAt(i) != ' ') i++;
            out[k++] = s.substring(st, i);
        }
        return out;
    }

    static String[][] wordLenTable(String[] words) {
        String[][] t = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            t[i][0] = words[i];
            t[i][1] = String.valueOf(lenByCharAt(words[i]));
        }
        return t;
    }

    static int[] shortestLongest(String[][] t) {
        if (t.length == 0) return new int[] {-1, -1};
        int s = 0, l = 0;
        for (int i = 1; i < t.length; i++) {
            int cur = Integer.parseInt(t[i][1]);
            if (cur < Integer.parseInt(t[s][1])) s = i;
            if (cur > Integer.parseInt(t[l][1])) l = i;
        }
        return new int[] {s, l};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] t = wordLenTable(splitByCharAt(text));
        int[] idx = shortestLongest(t);
        if (idx[0] == -1) {
            System.out.println("No words");
            return;
        }
        System.out.println("Shortest: " + t[idx[0]][0]);
        System.out.println("Longest: " + t[idx[1]][0]);
    }
}
