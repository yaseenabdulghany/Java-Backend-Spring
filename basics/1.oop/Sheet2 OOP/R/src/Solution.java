import java.util.Scanner;

public class Solution {
    Scanner scanner;
    int n, m;

    public Solution(Scanner scanner, int n, int m) {
        this.scanner = scanner;
        this.n = n;
        this.m = m;
    }

    public void solve() {
        while (n > 0 && m > 0) {
            int sum = 0;
            for (int i = Math.min(n, m); i <= Math.max(n, m); i++) {
                System.out.print(i + " ");
                sum += i;
            }
            System.out.println("sum =" + sum);
            n = scanner.nextInt();
            m = scanner.nextInt();
        }
    }
}