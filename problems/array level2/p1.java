import java.util.*;
public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salary = new double[10], service = new double[10], bonus = new double[10], newSalary = new double[10];
        double totalBonus = 0, totalOld = 0, totalNew = 0;
        for (int i = 0; i < 10; i++) {
            salary[i] = sc.nextDouble();
            service[i] = sc.nextDouble();
            if (salary[i] <= 0 || service[i] < 0) { i--; continue; }
        }
        for (int i = 0; i < 10; i++) {
            bonus[i] = salary[i] * (service[i] > 5 ? 0.05 : 0.02);
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i]; totalOld += salary[i]; totalNew += newSalary[i];
        }
        System.out.println(totalBonus + " " + totalOld + " " + totalNew);
    }
}
