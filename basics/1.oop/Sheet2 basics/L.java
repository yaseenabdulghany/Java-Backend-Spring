import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();
        int maxs = 0;
        for (int i = 1; i <= 1000; i++) {
            if (a % i == 0 && b % i == 0) {
                if (i > maxs) {
                    maxs = i;
                }
            }
        }
        System.out.print(maxs);
    }
}
