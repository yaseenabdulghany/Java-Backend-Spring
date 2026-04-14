public class T9 {
    static void methodA() {
        int result = 10 / 0;
    }

    static void methodB() {
        methodA();
    }

    public static void main(String[] args) {
        try {
            methodB();
        } catch (ArithmeticException e) {
            System.out.println("exception caught in main: " + e.getMessage());
        }
    }
}