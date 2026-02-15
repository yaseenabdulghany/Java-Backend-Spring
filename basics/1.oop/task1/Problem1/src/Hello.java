public class Hello {
    private String name;

    Hello(String name) {
        this.name = name;
    }

    void sayHello() {
        System.out.printf("Hello, %s", name);
    }
}