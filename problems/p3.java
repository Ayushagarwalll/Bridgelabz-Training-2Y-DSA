public class p3 {
    static long aComparisons(int n, int m) { return (long) m * n; }
    static long aMemory() { return 0; }
    static long bMemory(int n) { return (long) n * 8; }

    public static void main(String[] args) {
        int n = 40, m = 5;
        long perStudent = aComparisons(n, m);
        System.out.println("A per student comparisons=" + perStudent);
        System.out.println("A per day comparisons=" + (perStudent * 100000L));
        System.out.println("B memory per request bytes=" + bMemory(n));
        System.out.println("B concurrent memory for 10000 requests bytes=" + (bMemory(n) * 10000L));
        System.out.println("10ms limit at 0.1us/comparison => 100000 comparisons/check");
        System.out.println("Choose B for time, A for minimum memory, hybrid switch near m=3");
    }
}
