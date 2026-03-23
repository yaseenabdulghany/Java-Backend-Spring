import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

