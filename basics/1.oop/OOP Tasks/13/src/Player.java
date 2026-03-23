public class Player {
    int id;
    String name;
    Shirt shirt;

    public Player(int id, String name, Shirt shirt) {
        this.id = id;
        this.name = name;
        this.shirt = shirt;
    }

    public void showPlayer() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Shirt Number: " + shirt.number);
        System.out.println("Shirt Color: " + shirt.color);
    }
}