package pack2;

public class Main extends CaptainBenfit {
    public Main(int id, String benfitCaptain, String allCaptainbenfit) {
        super(id, benfitCaptain, allCaptainbenfit);
    }

    public static void main(String[] args) {
        Main m = new Main(1, "Armband", "All Benefits");
        System.out.println(m.id);
        System.out.println(m.benfitCaptain);
        System.out.println(m.allCaptainbenfit);
    }
}