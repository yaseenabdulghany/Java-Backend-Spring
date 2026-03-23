package pack1;

public class Main extends PlayerBenfit {
    public Main(int id, String benfitPlayer, String allPlayerbenfit) {
        super(id, benfitPlayer, allPlayerbenfit);
    }

    public static void main(String[] args) {
        Main m = new Main(1, "Bonus", "All Benefits");
        System.out.println(m.id);
        System.out.println(m.benfitPlayer);
        System.out.println(m.allPlayerbenfit);
    }
}