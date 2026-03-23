import java.util.ArrayList;

public class Order {
    int id;
    ArrayList<Food> foods = new ArrayList<>();

    public Order(int id) {
        this.id = id;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Food f : foods) {
            total += f.price;
        }
        return total;
    }
}