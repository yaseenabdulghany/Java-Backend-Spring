import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        int n;
        n = scanner.nextInt();
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.println("NO");
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.print("YES");
        }
    }
}
