import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.next();
        Hello h1 = new Hello(name);
        h1.sayHello();
    }
}