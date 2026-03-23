import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int e = 0, n;
        n = scanner.nextInt();
        for (int row = 0; row < n; row++) {
            for (int j = n - 1; j > row; j--) {
                System.out.print(" ");
            }
            for (int st = 0; st <= e; st++) {
                System.out.print("*");
            }
            System.out.println();
            e += 2;
        }
    }
}
