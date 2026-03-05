import java.util.Scanner;

public class R {

    void solve(int n, int m) {
        while (n > 0 && m > 0) {
            Scanner input = new Scanner(System.in);
            int sum = 0;
            for (int i = Math.min(n, m); i <= Math.max(n, m); i++) {
                System.out.print(i + " ");
                sum += i;
            }
            System.out.println("sum =" + sum);
            n = input.nextInt();
            m = input.nextInt();
        }
    }
}