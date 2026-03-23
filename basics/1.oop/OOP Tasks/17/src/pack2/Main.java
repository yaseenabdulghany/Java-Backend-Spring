package pack2;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(1, "Mr. Ali", true);
        System.out.println(teacher.id);
        System.out.println(teacher.name);
        System.out.println(teacher.active);
    }
}