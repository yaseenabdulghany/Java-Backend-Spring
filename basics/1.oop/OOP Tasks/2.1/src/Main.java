import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String name = input.next();
        App app = new App();
        app.setName(name);
        app.setNum(n);

        System.out.println(app.getName());
        System.out.println(app.getNum());
    }
}