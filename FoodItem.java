public class FoodItem extends MenuItem {
    public FoodItem(String name, double price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "Food Item";
    }
}
