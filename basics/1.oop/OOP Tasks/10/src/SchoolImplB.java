public class SchoolImplB extends School {
    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("You are on show student");
        for (Student s : students) {
            System.out.println("ID: " + s.id + " and Name: " + s.name);
        }
    }
}