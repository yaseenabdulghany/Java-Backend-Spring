import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, z = 0;
        x = scanner.nextInt();
        for (int i = 1; i <= x; i++) {
            long v;
            v = scanner.nextLong();
            if (v > z) {
                z = (int) v;
            }
        }
        System.out.print(z);
    }
}
