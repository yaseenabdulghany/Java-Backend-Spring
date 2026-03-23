import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        String name = scanner.next();
        int age = scanner.nextInt();
        Student student = new Student(id, name, age);
        student.showStudent();
    }
}