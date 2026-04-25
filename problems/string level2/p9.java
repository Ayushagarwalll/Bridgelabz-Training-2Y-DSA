import java.util.*;

public class p9 {
    static String compChoice() {
        int x = (int) (Math.random() * 3);
        return x == 0 ? "rock" : x == 1 ? "paper" : "scissors";
    }

    static int winner(String p, String c) {
        if (p.equals(c)) return 0;
        if ((p.equals("rock") && c.equals("scissors")) || (p.equals("paper") && c.equals("rock")) || (p.equals("scissors") && c.equals("paper"))) return 1;
        return -1;
    }

    static String[][] stats(int p, int c, int g) {
        String[][] s = new String[2][3];
        s[0][0] = "Player"; s[0][1] = String.valueOf(p); s[0][2] = String.valueOf(Math.round((p * 10000.0) / g) / 100.0);
        s[1][0] = "Computer"; s[1][1] = String.valueOf(c); s[1][2] = String.valueOf(Math.round((c * 10000.0) / g) / 100.0);
        return s;
    }

    static void show(String[][] games, String[][] s) {
        System.out.println("Game\tPlayer\tComputer\tWinner");
        for (String[] r : games) System.out.println(r[0] + "\t" + r[1] + "\t" + r[2] + "\t" + r[3]);
        System.out.println("Name\tWins\tPercent");
        for (String[] r : s) System.out.println(r[0] + "\t" + r[1] + "\t" + r[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] games = new String[n][4];
        int pw = 0, cw = 0;
        for (int i = 0; i < n; i++) {
            String p = sc.next().toLowerCase();
            String c = compChoice();
            int w = winner(p, c);
            if (w == 1) pw++;
            else if (w == -1) cw++;
            games[i][0] = String.valueOf(i + 1);
            games[i][1] = p;
            games[i][2] = c;
            games[i][3] = w == 1 ? "Player" : w == -1 ? "Computer" : "Draw";
        }
        show(games, stats(pw, cw, n));
    }
}
