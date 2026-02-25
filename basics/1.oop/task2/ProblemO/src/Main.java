import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        char ch = input.next().charAt(0);
        long b = input.nextLong();
        Solution sol = new Solution(a, ch, b);
        sol.calc();
    }
}