public class T11 {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("exception caught");
        } finally {
            System.out.println("finally block always executes");
        }
    }
}