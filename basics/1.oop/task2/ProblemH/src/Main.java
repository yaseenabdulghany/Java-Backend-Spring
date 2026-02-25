import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n = input.nextDouble();
        double m = input.nextDouble();
        Solution solution = new Solution(n, m);
        solution.floor();
        solution.ceil();
        solution.round();
    }
}