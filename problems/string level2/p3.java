import java.util.*;

public class p3 {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] t = wordLenTable(splitByCharAt(text));
        System.out.println("Word\tLength");
        for (String[] row : t) System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
    }
}
