public class T12 {
    public static void main(String[] args) {
        try {
            System.out.println("outer try block");
            try {
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("inner catch: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("outer catch: " + e.getMessage());
        }
    }
}