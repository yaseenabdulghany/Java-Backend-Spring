import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] v = new long[n];
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextLong();
        }
        Solution solution = new Solution(n, v);
        solution.solve();
    }
}