public class PrivateClub extends Club {
    public PrivateClub(String name) {
        super(name);
    }

    public void showPlayers() {
        System.out.println("Private Club: " + name);
        for (Player p : players) {
            System.out.println("ID: " + p.id + " and Name: " + p.name);
        }
    }
}