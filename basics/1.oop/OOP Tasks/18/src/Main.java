import pack1.PlayerBenfit;
import pack2.CaptainBenfit;

public class Main {
    static class MyPlayer extends PlayerBenfit {
        public MyPlayer(int id, String benfitPlayer, String allPlayerbenfit) {
            super(id, benfitPlayer, allPlayerbenfit);
        }
    }

    static class MyCaptain extends CaptainBenfit {
        public MyCaptain(int id, String benfitCaptain, String allCaptainbenfit) {
            super(id, benfitCaptain, allCaptainbenfit);
        }
    }

    public static void main(String[] args) {
        MyPlayer player = new MyPlayer(1, "Bonus", "All Benefits");
        System.out.println(player.id);
        System.out.println(player.benfitPlayer);

        MyCaptain captain = new MyCaptain(1, "benf", "All Benefits");
        System.out.println(captain.id);
        System.out.println(captain.benfitCaptain);
    }
}