public class p1 {
    static double avgA(int[] t) {
        int total = 0;
        for (int x : t) total += x;
        return (double) total / t.length;
    }

    static double avgB(int[] t) {
        double sum = t[0];
        for (int i = 1; i < t.length; i++) sum += t[i];
        for (int i = 0; i < t.length; i++) sum /= t.length;
        return sum;
    }

    static void traceA(int[] t) {
        int total = 0;
        for (int i = 0; i < t.length; i++) {
            total += t[i];
            System.out.println("A step " + (i + 1) + ": total=" + total);
        }
        System.out.println("A average=" + ((double) total / t.length));
    }

    static void traceB(int[] t) {
        double sum = t[0];
        System.out.println("B step 1: sum=" + sum);
        for (int i = 1; i < t.length; i++) {
            sum += t[i];
            System.out.println("B add " + (i + 1) + ": sum=" + sum);
        }
        for (int i = 0; i < t.length; i++) {
            sum /= t.length;
            System.out.println("B divide " + (i + 1) + ": sum=" + sum);
        }
    }

    public static void main(String[] args) {
        int[] t = {20, 25, 22, 24, 21};
        System.out.println("A result=" + avgA(t));
        System.out.println("B result=" + avgB(t));
        traceA(t);
        traceB(t);
    }
}
