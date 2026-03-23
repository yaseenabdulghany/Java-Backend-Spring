public class Player extends Info {
    private int number;
    void setNumber(int number) {
        if (number <= 99 && number >= 1) {
            this.number = number;
        } else {
            System.out.println("number length must be <= 2");
        }
    }
    int getNumber() {
        return this.number;
    }
}
