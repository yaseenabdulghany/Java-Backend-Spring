import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum = 0,n, a, b;
        n = scanner.nextLong();
        a = scanner.nextLong();
        b = scanner.nextLong();
        for (int i = 1; i <= n; i++) {
            int x = i;
            long sd = 0;
            while (x != 0) {
                int m = x % 10;
                sd += m;
                x /= 10;
            }
            if (sd >= a && sd <= b) {
                sum += i;
            }
        }
        System.out.print(sum);
    }
}
