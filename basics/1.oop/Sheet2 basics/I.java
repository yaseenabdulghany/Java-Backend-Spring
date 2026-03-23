import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long rev = 0,n;
        n = scanner.nextLong();
        long m = n;
        while (n != 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        if (m == rev) {
            System.out.println(rev);
            System.out.print("YES");
        } else {
            System.out.println(rev);
            System.out.print("NO");
        }
    }
}
