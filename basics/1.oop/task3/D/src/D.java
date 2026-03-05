import java.util.Scanner;

public class D {
    Scanner input = new Scanner(System.in);

    void solve() {
        for (int i = 0; ; i++) {
            int x = input.nextInt();
            if (x != 1999) {
                System.out.println("Wrong");
            } else if (x == 1999) {
                System.out.println("Correct");
                break;
            }
        }
    }
}
