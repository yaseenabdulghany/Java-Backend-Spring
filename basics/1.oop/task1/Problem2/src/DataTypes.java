public class DataTypes {
    private int x;
    private long y;
    private char z;
    private float w;
    private double f;

    DataTypes(int x, long y, char z, float w, double f) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.f = f;
    }

    void display() {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(w);
        System.out.println(f);
    }
}