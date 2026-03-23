import java.util.Scanner;

public class Solution {
    Scanner scanner;

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    public void solve() {
        int x;
        for (int i = 0; ; i++) {
            x = scanner.nextInt();
            if (x != 1999) {
                System.out.println("Wrong");
            } else if (x == 1999) {
                System.out.println("Correct");
                break;
            }
        }
    }
}