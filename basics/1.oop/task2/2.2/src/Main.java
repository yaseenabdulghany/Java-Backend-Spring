public class Main {
    public static void main(String[] args) {

        Teacher t1 = new Teacher();

        t1.setId(5L);
        t1.setName("ahmed");
        t1.setAge(30);
        t1.setPhoneNumber("+201113906600");
        t1.setSalary(5000);

        System.out.println("Valid Data:");
        System.out.println("Id: " + t1.getId());
        System.out.println("Name: " + t1.getName());
        System.out.println("Age: " + t1.getAge());
        System.out.println("Phone: " + t1.getPhoneNumber());
        System.out.println("Salary: " + t1.getSalary());

        System.out.println("---------------");

        Teacher t2 = new Teacher();

        t2.setId(-1L);
        t2.setName("ab1");
        t2.setAge(20);
        t2.setPhoneNumber("01113906600");
        t2.setSalary(2000);

        System.out.println("Invalid Data:");
        System.out.println("Id: " + t2.getId());
        System.out.println("Name: " + t2.getName());
        System.out.println("Age: " + t2.getAge());
        System.out.println("Phone: " + t2.getPhoneNumber());
        System.out.println("Salary: " + t2.getSalary());
    }
}