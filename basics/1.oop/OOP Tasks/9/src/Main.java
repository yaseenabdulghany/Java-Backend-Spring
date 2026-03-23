public class Main {
    public static void main(String[] args) {
        PublicClub publicClub = new PublicClub("Alahly");
        publicClub.addPlayer(new Player(1, "yaseen"));
        publicClub.addPlayer(new Player(2, "mohamed"));
        publicClub.showPlayers();


        PrivateClub privateClub = new PrivateClub("Zamalek");
        privateClub.addPlayer(new Player(3, "omar"));
        privateClub.addPlayer(new Player(4, "khaled"));
        privateClub.showPlayers();
    }
}