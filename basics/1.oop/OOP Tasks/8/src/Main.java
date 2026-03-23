public class Main {
    public static void main(String[] args) {
        Post post = new Post(1, "Hello java spring", "oop.jpg");

        SocialMediaApi facebook = new Facebook();
        facebook.showPost(post);

        SocialMediaApi linkedin = new LinkedIn();
        linkedin.showPost(post);
    }
}