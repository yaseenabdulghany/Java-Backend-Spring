public class Difference {
    private int a, b, c, d;

    public Difference(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    void difference() {
        System.out.printf("Difference = %d", (a * b) - (c * d));
    }
}