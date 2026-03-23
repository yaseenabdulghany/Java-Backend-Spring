public class SchoolImplA extends School {
    public void addStudent(Student student) {
        System.out.println("You are on add student");
        students.add(student);
    }

    public void showStudents() {
        for (Student s : students) {
            System.out.println("ID: " + s.id + " and Name: " + s.name);
        }
    }
}