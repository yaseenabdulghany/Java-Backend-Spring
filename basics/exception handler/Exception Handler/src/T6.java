public class T6 {
    public static void main(String[] args) {
        try {
            String s = null;
            System.out.println(s.length());
            int result = 10 / 0;
        } catch (NullPointerException e) {
            System.out.println("null pointer exception caught");
        } catch (ArithmeticException e) {
            System.out.println("arithmetic exception caught!");
        }
    }
}