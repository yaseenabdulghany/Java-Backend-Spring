public class App {
    private int num;
    private String name;

    public void setNum(int num) {
        if (num > 0) {
            this.num = num;
        } else {
            System.out.println("number should be > 0");
        }
    }
    public void setName(String name) {
        if (name.length() > 5) {
            this.name = name;
        } else {
            System.out.println("name size  should be > 5");
        }
    }
    public int getNum() {
        return num;
    }
    public String getName() {
        return name;
    }
}
