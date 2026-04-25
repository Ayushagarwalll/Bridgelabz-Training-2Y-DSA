import java.util.*;

public class p6 {
    static void generate(String text) {
        System.out.println(text.substring(3, 1));
    }

    static void handle(String text) {
        try {
            try {
                System.out.println(text.substring(3, 1));
            } catch (StringIndexOutOfBoundsException e) {
                throw new IllegalArgumentException("start index greater than end index");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IllegalArgumentException");
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
