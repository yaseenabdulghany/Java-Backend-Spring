public class Main {
    public static void main(String[] args) {
        Shirt shirt = new Shirt(10, "Red");
        Player player = new Player(1, "Ahmed", shirt);
        player.showPlayer();
    }
}