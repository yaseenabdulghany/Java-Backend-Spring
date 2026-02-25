public class Student extends ShareData {
    private int age;

    public Student(int id, String name, String phone, int age) {
        super(id, name, phone);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String display() {
        return super.display() + ", Age: " + age;
    }
}
