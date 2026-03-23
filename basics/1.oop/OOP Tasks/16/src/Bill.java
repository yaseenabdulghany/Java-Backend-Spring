public class Bill {
    int id;
    Order order;
    Gift gift;

    public Bill(int id, Order order, Gift gift) {
        this.id = id;
        this.order = order;
        this.gift = gift;
    }

    public void showBill() {
        System.out.println("Bill ID: " + id);
        System.out.println("Order ID: " + order.id);
        System.out.println("Foods:");
        for (Food f : order.foods) {
            System.out.println("  ID: " + f.id + " and Name: " + f.name + " , Price: " + f.price);
        }
        System.out.println("Total: " + order.getTotalPrice());
        if (gift != null) {
            System.out.println("Gift: " + gift.name);
        }
    }
}