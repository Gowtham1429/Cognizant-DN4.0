import java.util.Scanner;

public class ForecastCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter growth rate (%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double futureValue = calculateFutureValue(currentValue, growthRate, years);
        System.out.printf("Predicted future value after %d years: %.2f\n", years, futureValue);
    }

    static double calculateFutureValue(double value, double rate, int years) {
        if (years == 0) return value;
        return calculateFutureValue(value * (1 + rate / 100), rate, years - 1);
    }
}
