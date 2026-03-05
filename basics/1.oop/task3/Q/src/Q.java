import java.util.Scanner;

public class Q {
    void solve(int n) {
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            int x = input.nextInt();
            while (x == 0) {
                System.out.print(0 + " ");
                break;
            }
            while (x != 0) {
                System.out.print(x % 10 + " ");
                x = x / 10;
            }
            System.out.println();
        }
    }
}