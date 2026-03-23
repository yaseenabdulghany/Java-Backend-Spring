public class Main {
    public static void main(String[] args) {
        RestaurantController controller = new RestaurantController();
        controller.addOrder(new Order(1, "Pizza"));
        controller.addOrder(new Order(2, "Burger"));
        controller.addOrder(new Order(3, "Pasta"));
        controller.showOrders();
    }
}