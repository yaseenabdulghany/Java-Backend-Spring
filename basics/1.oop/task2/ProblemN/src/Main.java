import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char c = input.next().charAt(0);
        Solution sol = new Solution();
        System.out.println(sol.solve(c));
    }
}