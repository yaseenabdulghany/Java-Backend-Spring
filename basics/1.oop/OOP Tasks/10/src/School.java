import java.util.ArrayList;

public abstract class School {
    ArrayList<Student> students = new ArrayList<>();

    public abstract void addStudent(Student student);
    public abstract void showStudents();
}