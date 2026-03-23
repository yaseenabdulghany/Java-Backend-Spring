import java.util.ArrayList;

public class Student {
    int id;
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void showStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Courses:");
        for (Course c : courses) {
            System.out.println("  ID: " + c.id + " and Name: " + c.name);
        }
    }
}