public class Student {
    int id;
    String name;
    Email email;

    public Student(int id, String name, Email email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void showStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email.address);
        System.out.println("Password: " + email.password);
    }
}