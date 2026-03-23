import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 2; i <= n; i += 2)
            System.out.println(i);
        if (n < 2) {
            System.out.println("-1");
        }
    }
}
