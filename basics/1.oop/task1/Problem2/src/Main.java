import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        long y = input.nextLong();
        char z = input.next().charAt(0);
        float w = input.nextFloat();
        double f = input.nextDouble();
        DataTypes d1 = new DataTypes(x, y, z, w, f);
        d1.display();
    }
}