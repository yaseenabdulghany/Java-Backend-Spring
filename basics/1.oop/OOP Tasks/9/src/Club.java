import java.util.ArrayList;

public abstract class Club {
    String name;
    ArrayList<Player> players = new ArrayList<>();

    public Club(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public abstract void showPlayers();
}