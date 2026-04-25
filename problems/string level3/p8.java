import java.util.*;

public class p8 {
    static boolean isAnagram(String a, String b) {
        a = a.replace(" ", "").toLowerCase();
        b = b.replace(" ", "").toLowerCase();
        if (a.length() != b.length()) return false;
        int[] f = new int[256];
        for (int i = 0; i < a.length(); i++) {
            f[a.charAt(i)]++;
            f[b.charAt(i)]--;
        }
        for (int v : f) if (v != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(isAnagram(s1, s2));
    }
}
