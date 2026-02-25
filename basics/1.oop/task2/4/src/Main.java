public class Main {
    public static void main(String[] args) {

        Player p = new Player();
        p.setId(10);
        p.setName("Ali");
        p.setNumber(25);

        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getNumber());

        Player p2 = new Player();
        p2.setId(-5);
        p2.setName("Omar");
        p2.setNumber(150);

        System.out.println(p2.getId());
        System.out.println(p2.getName());
        System.out.println(p2.getNumber());

        Student s = new Student();
        s.setId(7);
        s.setName("Mona");
        s.setAge(20);

        System.out.println(s.getId());
        System.out.println(s.getName());
        System.out.println(s.getAge());

        Student s2 = new Student();
        s2.setId(0);
        s2.setName("Sara");
        s2.setAge(5);

        System.out.println(s2.getId());
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
    }
}