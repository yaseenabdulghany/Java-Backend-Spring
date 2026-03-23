public class ClupFc extends Player{
    private String Fcode;

    public ClupFc(int id, String name, int number, String Fcode) {
        super(id, name, number);  // Call Player constructor
        this.Fcode = Fcode;
    }

    public String getFcode() {
        return Fcode;
    }

    public void setFcode(String Fcode) {
        this.Fcode = Fcode;
    }

    @Override
    public String display() {
        return super.display() + ", Fcode: " + Fcode;
    }
}
