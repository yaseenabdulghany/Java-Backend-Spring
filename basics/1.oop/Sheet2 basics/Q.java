import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            String t;
            t = scanner.next();
            int sz = t.length();
            for (int j = sz - 1; j >= 0; j--) {
                System.out.print(t.charAt(j) + " ");
            }
            System.out.println();
        }
    }
}
