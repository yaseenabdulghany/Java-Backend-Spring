import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x, y, ans = 1;
        x = scanner.nextLong();
        for (int i = 1; i <= x; i++) {
            y = scanner.nextLong();
            for (int j = 1; j <= y; j++) {
                ans *= j;
            }
            System.out.println(ans);
            ans = 1;
        }
    }
}
