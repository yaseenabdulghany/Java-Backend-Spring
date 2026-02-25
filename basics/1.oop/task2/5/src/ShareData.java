public class ShareData extends BaseEntity {
    private String phone;

    public ShareData(int id, String name, String phone) {
        super(id, name);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String display() {
        return super.display() + ", Phone: " + phone;
    }
}

