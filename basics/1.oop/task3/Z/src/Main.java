import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int s = input.nextInt();
        Z solution = new Z();
        solution.solve(k,s);
    }
}