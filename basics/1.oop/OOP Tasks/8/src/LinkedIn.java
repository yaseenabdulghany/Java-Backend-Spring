public class LinkedIn implements SocialMediaApi {
    public void showPost(Post post) {
        System.out.println("You are on application LinkedIn");
        System.out.println("ID: " + post.id);
        System.out.println("Text: " + post.text);
        System.out.println("Image: " + post.image);
    }
}