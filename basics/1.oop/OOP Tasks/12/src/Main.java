public class Main {
    public static void main(String[] args) {
        Post post1 = new Post(1, "Hello World!");
        post1.showPost();

        Post post2 = new Post(2, "Check this out", "photo.jpg");
        post2.showPost();
    }
}