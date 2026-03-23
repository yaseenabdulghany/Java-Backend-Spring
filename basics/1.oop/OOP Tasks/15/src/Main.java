public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Ahmed");
        student.addCourse(new Course(1, "Math"));
        student.addCourse(new Course(2, "Science"));
        student.addCourse(new Course(3, "English"));
        student.showStudent();
    }
}