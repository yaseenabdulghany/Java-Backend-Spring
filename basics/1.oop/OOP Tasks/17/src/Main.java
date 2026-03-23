import pack1.Student;
import pack2.Teacher;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Ahmed", 90);
        System.out.println(student.id);
        System.out.println(student.name);

        Teacher teacher = new Teacher(1, "Mr Ali", true);
        System.out.println(teacher.id);
        System.out.println(teacher.name);
    }
}