import java.util.*;
import java.util.stream.*;

public class Main {

    static class Student {
        String name, department;
        double grade;
        Student(String name, String department, double grade) {
            this.name = name; this.department = department; this.grade = grade;
        }
        public double getGrade() { return grade; }
        public String toString() { return name + "(" + grade + ")"; }
    }

    static class Employee {
        String name, department;
        int age;
        double salary;
        Employee(String name, int age, String department, double salary) {
            this.name = name; this.age = age; this.department = department; this.salary = salary;
        }
        public String getName() { return name; }
        public double getSalary() { return salary; }
        public String toString() { return name + "(" + salary + ")"; }
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85), new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60), new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45), new Student("Laila", "IS", 78)
        );

        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000), new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500), new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000), new Employee("Laila", 35, "Finance", 8200)
        );

        System.out.println(employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName)).collect(Collectors.toList()));

        System.out.println(numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1));

        Set<Integer> seen = new HashSet<>();
        System.out.println(numbers.stream().filter(n -> !seen.add(n)).distinct().collect(Collectors.toList()));

        System.out.println(names.stream().filter(n -> n != null && !n.isEmpty()).collect(Collectors.toList()));

        System.out.println(students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= 50)));
    }
}