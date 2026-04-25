public class p2 {
    static long linearWorst(long n) { return n; }
    static long binaryWorst(long n) { return (long) Math.ceil(Math.log(n) / Math.log(2)); }
    static long hashWorst(long n) { return 1; }

    static long breakEven(long n) {
        double denom = n - Math.log(n) / Math.log(2);
        return (long) Math.ceil((n * Math.log(n) / Math.log(2)) / denom);
    }

    public static void main(String[] args) {
        long[] ns = {100, 1000, 10000, 100000, 1000000, 10000000};
        for (long n : ns)
            System.out.println(n + ": linear=" + n + ", binary=" + binaryWorst(n) + ", hash=" + hashWorst(n));
        long n = 10000000L;
        System.out.println("10M worst: linear=" + linearWorst(n) + ", binary=" + binaryWorst(n) + ", hash=" + hashWorst(n));
        System.out.println("50k checks/sec time ns: linear=" + (50000L * linearWorst(n)) + ", binary=" + (50000L * binaryWorst(n)) + ", hash=" + (50000L * hashWorst(n)));
        System.out.println("break-even searches for sort+binary vs repeated linear at n=10M: " + breakEven(n));
    }
}
