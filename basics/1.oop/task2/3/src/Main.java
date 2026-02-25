public class Main {
    public static void main(String[] args) {

        App a1 = new App();

        a1.setNum1(4);
        a1.setNum2(6);
        a1.setNum3(8);

        System.out.println(a1.getNum1());
        System.out.println(a1.getNum2());
        System.out.println(a1.getNum3());
        System.out.println(a1.sum());

        System.out.println("---------------");

        App a2 = new App();

        a2.setNum1(3);
        a2.setNum2(5);
        a2.setNum3(10);

        System.out.println(a2.getNum1());
        System.out.println(a2.getNum2());
        System.out.println(a2.getNum3());
        System.out.println(a2.sum());
    }
}