import java.util.Scanner;

public class Admin {
    private Restaurant restaurant;

    public Admin(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void manageMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdmin Menu Management");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. Show Menu");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    restaurant.addMenuItem(new MenuItem(name, price));
                    System.out.println("Item added.");
                    break;
                case 2:
                    restaurant.showMenu();
                    System.out.print("Enter item number to remove: ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < restaurant.getMenu().size()) {
                        restaurant.removeMenuItem(restaurant.getMenu().get(index));
                        System.out.println("Item removed.");
                    } else {
                        System.out.println("Invalid item number.");
                    }
                    break;
                case 3:
                    restaurant.showMenu();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}