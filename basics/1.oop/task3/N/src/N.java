import java.util.Scanner;

public class N {
    void solve(char s, int n) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            for (int j = 0; j < a; j++) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}