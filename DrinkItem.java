public class DrinkItem extends MenuItem {
    public DrinkItem(String name, double price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "Drink Item";
    }
}
