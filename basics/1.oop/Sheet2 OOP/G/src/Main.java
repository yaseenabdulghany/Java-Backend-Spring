import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long[] v = new long[(int) x];
        for (int i = 0; i < x; i++) {
            v[i] = scanner.nextLong();
        }
        Solution solution = new Solution(x, v);
        solution.solve();
    }
}