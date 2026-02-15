    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int a, b, c, d;
            a = input.nextInt();
            b = input.nextInt();
            c = input.nextInt();
            d = input.nextInt();

            Difference d1 = new Difference(a, b, c, d);
            d1.difference();
        }
    }