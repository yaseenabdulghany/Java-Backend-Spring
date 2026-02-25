public class Main {
    public static void main(String[] args) {
        Person person = new Person(1, "Ali");
        Player player = new Player(2, "Ahmed", "201022549218", 10);
        Student student = new Student(3, "Omar", "201284579130", 20);

        System.out.println(person.display());
        System.out.println(player.display());
        System.out.println(student.display());
    }
}