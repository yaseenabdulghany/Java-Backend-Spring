public class Main {
    public static void main(String[] args) {
        Food food1 = new Food(1, "Pizza", 50.0);
        Food food2 = new Food(2, "Burger", 30.0);
        Food food3 = new Food(3, "Pasta", 40.0);

        Order order = new Order(1);
        order.addFood(food1);
        order.addFood(food2);
        order.addFood(food3);

        Gift gift = new Gift(1, "Free Drink");

        Bill bill = new Bill(1, order, gift);

        Person person = new Person(1, "Ahmed", bill);
        person.showPerson();
    }
}