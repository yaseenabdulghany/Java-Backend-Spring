import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        long[] v = new long[x];
        for (int i = 0; i < x; i++) {
            v[i] = scanner.nextLong();
        }
        Solution solution = new Solution(x, v);
        solution.solve();
    }
}