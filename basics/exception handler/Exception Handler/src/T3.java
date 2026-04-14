public class T3 {
    static void toUpper(String s) {
        try {
            System.out.println(s.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("String is null");
        }
    }

    public static void main(String[] args) {
        toUpper(null);
    }
}