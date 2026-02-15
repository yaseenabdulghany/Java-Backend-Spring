import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double r = input.nextDouble();

        Circle circle = new Circle(r);
        double area = circle.area();
        System.out.printf("%.9f", area);
    }
}