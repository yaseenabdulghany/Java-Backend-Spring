import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = scanner.nextInt();
            ys[i] = scanner.nextInt();
        }
        Solution solution = new Solution(n, xs, ys);
        solution.solve();
    }
}