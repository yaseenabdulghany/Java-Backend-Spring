public class Post {
    int id;
    String text;
    String image;

    public Post(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Post(int id, String text, String image) {
        this.id = id;
        this.text = text;
        this.image = image;
    }

    public void showPost() {
        System.out.println("ID: " + id);
        System.out.println("Text: " + text);
        if (image != null) {
            System.out.println("Image: " + image);
        }
    }
}