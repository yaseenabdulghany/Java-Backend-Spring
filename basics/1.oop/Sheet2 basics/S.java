import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, x, y;
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int odd = 0;
            x = scanner.nextInt();
            y = scanner.nextInt();
            for (int j = Math.min(x, y) + 1; j < Math.max(x, y); j++) {
                if (j % 2 != 0) {
                    odd += j;
                }
            }
            System.out.println(odd);
        }
    }
}
