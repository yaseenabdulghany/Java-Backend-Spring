import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        G sol = new G();
        System.out.println(sol.fact(n));
    }
}