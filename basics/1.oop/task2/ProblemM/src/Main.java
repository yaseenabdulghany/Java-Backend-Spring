import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char a = input.next().charAt(0);
        Solution sol = new Solution();
        sol.solve(a);
    }
}