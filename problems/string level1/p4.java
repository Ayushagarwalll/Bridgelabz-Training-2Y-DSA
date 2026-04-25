public class p4 {
    static void generateNPE() {
        String text = null;
        System.out.println(text.length());
    }

    static void handleNPE() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException");
        }
    }

    public static void main(String[] args) {
        try {
            generateNPE();
        } catch (NullPointerException e) {
            System.out.println("Generated NullPointerException");
        }
        handleNPE();
    }
}
