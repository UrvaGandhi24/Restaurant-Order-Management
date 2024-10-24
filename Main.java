import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(); // Automatically populated menu
        Admin admin = new Admin(restaurant);
        Customer customer = new Customer(restaurant);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nRestaurant Order Management System");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    admin.manageMenu();
                    break;
                case 2:
                    customer.placeOrder();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    scanner.close(); // Closing scanner before exiting
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
