import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        int n;
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = x; j <= x + 2; j++) {
                System.out.print(j + " ");
            }
            System.out.println("PUM");
            x += 4;
        }
    }
}
