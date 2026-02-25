import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.solve(n, m));
    }
}