import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int k, s;
        k = scanner.nextInt();
        s = scanner.nextInt();
        for (int x = 0; x <= k; x++) {
            for (int y = 0; y <= k; y++) {
                int z = s - (x + y);
                if (z >= 0 && z <= k) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
