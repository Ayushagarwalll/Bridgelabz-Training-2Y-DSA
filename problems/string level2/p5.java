import java.util.*;

public class p5 {
    static String charType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    static int[] countVowelConsonant(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            String t = charType(s.charAt(i));
            if (t.equals("Vowel")) c[0]++;
            else if (t.equals("Consonant")) c[1]++;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] c = countVowelConsonant(text);
        System.out.println("Vowels=" + c[0]);
        System.out.println("Consonants=" + c[1]);
    }
}
