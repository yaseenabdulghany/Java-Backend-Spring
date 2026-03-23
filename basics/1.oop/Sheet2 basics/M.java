import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();
        for (int n = a; n <= b; n++) {
            int m = n;
            boolean luk = true;
            while (m != 0) {
                if (m % 10 != 4 && m % 10 != 7)
                    luk = false;
                m /= 10;
            }
            if (luk == true) {
                System.out.print(n + " ");
                count++;
            }
        }
        if (count == 0) {
            System.out.print("-1");
        }
    }
}
