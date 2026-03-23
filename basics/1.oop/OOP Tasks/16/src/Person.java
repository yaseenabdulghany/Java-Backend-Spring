public class Person {
    int id;
    String name;
    Bill bill;

    public Person(int id, String name, Bill bill) {
        this.id = id;
        this.name = name;
        this.bill = bill;
    }

    public void showPerson() {
        System.out.println("Person ID: " + id);
        System.out.println("Person Name: " + name);
        bill.showBill();
    }
}