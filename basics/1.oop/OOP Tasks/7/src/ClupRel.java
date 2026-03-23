public class ClupRel extends Player {
    private String Rcode;

    public ClupRel(int id, String name, int number, String Rcode) {
        super(id, name, number);  // Call Player constructor
        this.Rcode = Rcode;
    }

    public String getRcode() {
        return Rcode;
    }

    public void setRcode(String Rcode) {
        this.Rcode = Rcode;
    }

    @Override
    public String display() {
        return super.display() + ", Rcode: " + Rcode;
    }

}
