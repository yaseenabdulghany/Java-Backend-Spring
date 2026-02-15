import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int id = input.nextInt();
        String name = input.next();
        int age = input.nextInt();

        Student student = new Student(id, name, age);
        student.printInfo();
    }
}