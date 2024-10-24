import java.util.Scanner;

public class Customer {
    private Restaurant restaurant;

    public Customer(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            restaurant.showMenu();
            System.out.print("Enter item number to order (0 to finish): ");
            int itemNumber = scanner.nextInt();
            if (itemNumber == 0) {
                break;
            }
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if (itemNumber > 0 && itemNumber <= restaurant.getMenu().size()) {
                MenuItem menuItem = restaurant.getMenu().get(itemNumber - 1);
                order.addItem(new OrderItem(menuItem, quantity));
                System.out.println("Item added to order.");
            } else {
                System.out.println("Invalid item number.");
            }
        }

        if (!order.getOrderItems().isEmpty()) {
            restaurant.addOrder(order);
            Bill bill = new Bill(order);
            bill.generateBill();
        } else {
            System.out.println("No items ordered.");
        }
    }
}
