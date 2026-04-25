public class p4 {
    static boolean mysteryFaster(long n) {
        return 5L * n * n + 100L * n + 1000 < 10L * n * (Math.log(n) / Math.log(2));
    }

    public static void main(String[] args) {
        long[] ns = {10, 20, 50, 100, 200, 500, 1000};
        for (long n : ns)
            System.out.println(n + ": mysteryFaster=" + mysteryFaster(n));
        System.out.println("Use merge sort for large n; insertion sort for tiny nearly sorted data; quick sort for random data; avoid bubble sort.");
    }
}
