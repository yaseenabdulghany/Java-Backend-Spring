public class PublicClub extends Club {
    public PublicClub(String name) {
        super(name);
    }

    public void showPlayers() {
        System.out.println("Public Club: " + name);
        for (Player p : players) {
            System.out.println("ID: " + p.id + " and Name: " + p.name);
        }
    }
}