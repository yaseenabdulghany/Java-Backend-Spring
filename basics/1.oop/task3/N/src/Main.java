import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char s =  input.next().charAt(0);
        int n = input.nextInt();
        N sol = new N();
        sol.solve(s, n);
    }
}