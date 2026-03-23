import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int e = 1;
        int n;
        n = scanner.nextInt();
        int spac = n - 1;
        for (int row = 1; row <= n; row++) {
            for (int j = spac; j > 0; j--) {
                System.out.print(" ");
            }
            spac--;
            for (int st = 1; st <= e; st++) {
                System.out.print("*");
            }
            System.out.println();
            e += 2;
        }
        e -= 2;
        int sp = 1;
        for (int row = 1; row <= n; row++) {
            for (int j = 1; j < sp; j++) {
                System.out.print(" ");
            }
            sp++;
            for (int st = e; st > 0; st--) {
                System.out.print("*");
            }
            e -= 2;
            System.out.println();
        }
    }
}
