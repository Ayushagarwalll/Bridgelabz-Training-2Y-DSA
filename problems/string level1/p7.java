import java.util.*;

public class p7 {
    static void generate(String text) {
        System.out.println(Integer.parseInt(text));
    }

    static void handle(String text) {
        try {
            System.out.println(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException");
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        try {
            generate(text);
        } catch (RuntimeException e) {
            System.out.println("Generated RuntimeException");
        }
        handle(text);
    }
}
