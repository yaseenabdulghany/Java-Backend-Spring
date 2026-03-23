public class Main {
    public static void main(String[] args) {
        SchoolImplA schoolA = new SchoolImplA();
        schoolA.addStudent(new Student(1, "Ahmed"));
        schoolA.addStudent(new Student(2, "Mohamed"));
        schoolA.showStudents();

        SchoolImplB schoolB = new SchoolImplB();
        schoolB.addStudent(new Student(3, "Ali"));
        schoolB.addStudent(new Student(4, "Omar"));
        schoolB.showStudents();
    }
}