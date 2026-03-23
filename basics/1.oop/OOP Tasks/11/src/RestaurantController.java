public class RestaurantController extends Restaurant {
    public void showOrders() {
        for (Order o : orders) {
            System.out.println("ID: " + o.id + " ,Item: " + o.item);
        }
    }
}