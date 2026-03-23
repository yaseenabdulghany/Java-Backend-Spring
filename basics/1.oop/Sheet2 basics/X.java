import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            long t;
            t = scanner.nextLong();
            int p = 0;
            long sum = 0;
            while (t != 0) {
                int y = (int)(t % 2);
                t /= 2;
                if (y == 1) {
                    sum += (long)Math.pow(2, p);
                    p++;
                }
            }
            System.out.println(sum);
        }
    }
}
