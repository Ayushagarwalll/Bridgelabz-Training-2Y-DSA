import java.util.*;

public class p6 {
    static String charType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    static String[][] mapChars(String s) {
        String[][] t = new String[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            t[i][0] = String.valueOf(s.charAt(i));
            t[i][1] = charType(s.charAt(i));
        }
        return t;
    }

    static void show(String[][] t) {
        System.out.println("Char\tType");
        for (String[] row : t) System.out.println(row[0] + "\t" + row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        show(mapChars(text));
    }
}
