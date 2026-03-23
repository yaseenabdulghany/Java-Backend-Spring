import java.util.ArrayList;

public abstract class Restaurant {
    ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public abstract void showOrders();
}