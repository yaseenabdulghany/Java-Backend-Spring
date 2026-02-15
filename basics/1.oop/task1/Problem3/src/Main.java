import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        Calculator calc = new Calculator();
        calc.sum(num1, num2);
        calc.multiply(num1, num2);
        calc.subtract(num1, num2);

    }
}