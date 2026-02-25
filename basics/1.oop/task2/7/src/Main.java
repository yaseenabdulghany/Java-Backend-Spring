public class Main {
    public static void main(String[] args) {
        ClupFc clupFcPlayer = new ClupFc(1, "yaseen", 10, "F123");
        ClupRel clupRelPlayer = new ClupRel(2, "ali", 7, "R456");

        System.out.println("ClupFc Player: " + clupFcPlayer.display());
        System.out.println("ClupRel Player: " + clupRelPlayer.display());
    }
}