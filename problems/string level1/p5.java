import java.util.*;

public class p5 {
    static void generate(String text) {
        System.out.println(text.charAt(text.length()));
    }

    static void handle(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled StringIndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        try {
            generate(text);
        } catch (RuntimeException e) {
            System.out.println("Generated StringIndexOutOfBoundsException");
        }
        handle(text);
    }
}
