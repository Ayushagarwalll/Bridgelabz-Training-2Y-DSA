import java.util.*;

public class p10 {
    static String[] initDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int k = 0;
        for (String s : suits) for (String r : ranks) deck[k++] = r + " of " + s;
        return deck;
    }

    static void shuffle(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int j = i + (int) (Math.random() * (n - i));
            String t = deck[i];
            deck[i] = deck[j];
            deck[j] = t;
        }
    }

    static String[][] distribute(String[] deck, int n, int players) {
        if (players <= 0 || n > deck.length || n % players != 0) return new String[0][0];
        int each = n / players;
        String[][] out = new String[players][each];
        int k = 0;
        for (int i = 0; i < players; i++) for (int j = 0; j < each; j++) out[i][j] = deck[k++];
        return out;
    }

    static void show(String[][] p) {
        if (p.length == 0) {
            System.out.println("Cannot distribute cards equally");
            return;
        }
        for (int i = 0; i < p.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (String c : p[i]) System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), players = sc.nextInt();
        String[] deck = initDeck();
        shuffle(deck);
        show(distribute(deck, n, players));
    }
}
