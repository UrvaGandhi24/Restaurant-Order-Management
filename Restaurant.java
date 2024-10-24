import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<MenuItem> menu;
    private List<Order> orders;

    public Restaurant() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
        populateMenu(); // Populate menu with built-in items
    }

    private void populateMenu() {
        // Soups
        menu.add(new FoodItem("Tomato Soup", 5.99));
        menu.add(new FoodItem("Manchow Soup", 6.99));

        // Starters
        menu.add(new FoodItem("Paneer Pakora", 7.99));
        menu.add(new FoodItem("Veg Spring Roll", 6.99));

        // Punjabi Food
        menu.add(new FoodItem("Paneer Butter Masala", 12.99));
        menu.add(new FoodItem("Palak Paneer", 11.99));
        menu.add(new FoodItem("Paneer Tikka", 10.99));

        // Vegetables (Veg)
        menu.add(new FoodItem("Mixed Vegetable Curry", 9.99));
        menu.add(new FoodItem("Bhindi Masala", 8.99));
        menu.add(new FoodItem("Undhiyu", 13.99));
        menu.add(new FoodItem("Sev Tameta Nu Shaak", 9.99));

        // Types of Rotis
        menu.add(new FoodItem("Butter Roti", 2.49));
        menu.add(new FoodItem("Garlic Naan", 3.49));
        menu.add(new FoodItem("Missi Roti", 2.99));

        // Rice-Dal
        menu.add(new FoodItem("Dal Tadka", 8.99));
        menu.add(new FoodItem("Jeera Rice", 7.99));

        // Desserts
        menu.add(new FoodItem("Gulab Jamun", 4.99));
        menu.add(new FoodItem("Rasgulla", 4.99));

        // Drinks
        menu.add(new DrinkItem("Coke", 2.99));
        menu.add(new DrinkItem("Sprite", 2.99));
        menu.add(new DrinkItem("Fanta", 2.99));
        menu.add(new DrinkItem("Mineral Water", 1.50));
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void showMenu() {
        System.out.println("\n=======================");
        System.out.println("      Restaurant Menu");
        System.out.println("=======================\n");
        
        showSection("Soups");
        showSection("Starters");
        showSection("Punjabi Food");
        showSection("Vegetables (Veg)");
        showSection("Types of Rotis");
        showSection("Rice-Dal");
        showSection("Desserts");
        showSection("Drinks");
        
        System.out.println("=======================");
    }

    private void showSection(String section) {
        System.out.println(section + ":");
        int count = 0;
        for (MenuItem item : menu) {
            if (getSection(item).equals(section)) {
                count++;
                System.out.printf("%d. %-30s $%.2f%n", count, item.getName(), item.getPrice());
            }
        }
        System.out.println();
    }

    private String getSection(MenuItem item) {
        String name = item.getName().toLowerCase();
        if (name.contains("soup")) return "Soups";
        if (name.contains("pakora") || name.contains("spring roll")) return "Starters";
        if (name.contains("paneer") || name.contains("butter")) return "Punjabi Food";
        if (name.contains("vegetable") || name.contains("bhindi") || name.contains("undhiyu") || name.contains("shaak")) return "Vegetables (Veg)";
        if (name.contains("roti") || name.contains("naan")) return "Types of Rotis";
        if (name.contains("dal") || name.contains("rice")) return "Rice-Dal";
        if (name.contains("gulab") || name.contains("rasgulla")) return "Desserts";
        return "Drinks";
    }
}
