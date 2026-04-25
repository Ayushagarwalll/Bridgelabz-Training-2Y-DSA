import java.util.*;

public class p9 {
    static String monthName(int m) {
        String[] names = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return names[m - 1];
    }

    static boolean leap(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }

    static int daysInMonth(int m, int y) {
        int[] d = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (m == 2 && leap(y)) return 29;
        return d[m - 1];
    }

    static int firstDay(int m, int y) {
        int d = 1;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (d + x + (31 * m0) / 12) % 7;
    }

    static void showCalendar(int m, int y) {
        int first = firstDay(m, y), days = daysInMonth(m, y);
        System.out.println(monthName(m) + " " + y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < first; i++) System.out.print("    ");
        for (int d = 1; d <= days; d++) {
            System.out.printf("%4d", d);
            if ((first + d) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), y = sc.nextInt();
        if (m < 1 || m > 12 || y < 1) {
            System.out.println("Invalid month/year");
            return;
        }
        showCalendar(m, y);
    }
}
