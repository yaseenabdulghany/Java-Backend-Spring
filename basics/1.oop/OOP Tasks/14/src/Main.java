public class Main {
    public static void main(String[] args) {
        Email email = new Email("ahmed@gmail.com", "12345");
        Student student = new Student(1, "Ahmed", email);
        student.showStudent();
    }
}