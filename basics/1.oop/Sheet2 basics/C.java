import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, a = 0, b = 0, c = 0, d = 0;
        x = scanner.nextInt();
        for (int i = 1; i <= x; i++) {
            int v;
            v = scanner.nextInt();
            if (v % 2 == 0) {
                a++;
            } else if (v % 2 != 0) {
                b++;
            }
            if (v > 0) {
                c++;
            } else if (v < 0) {
                d++;
            }
        }
        System.out.println("Even: " + a);
        System.out.println("Odd: " + b);
        System.out.println("Positive: " + c);
        System.out.println("Negative: " + d);
    }
}
