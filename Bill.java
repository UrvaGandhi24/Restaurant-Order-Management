import java.util.List;

public class Bill {
    private Order order;

    public Bill(Order order) {
        this.order = order;
    }

    public void generateBill() {
        System.out.println("\n==================================================");
        System.out.println("                      Bill");
        System.out.println("==================================================");
        System.out.println("Item Description                Quantity     Price");
        System.out.println("--------------------------------------------------");

        List<OrderItem> orderItems = order.getOrderItems();
        double total = 0;

        for (OrderItem orderItem : orderItems) {
            double itemTotal = orderItem.getTotalPrice();
            total += itemTotal;
            System.out.printf("%-30s %d            $%.2f%n", 
                orderItem.getMenuItem().getName(), 
                orderItem.getQuantity(), 
                itemTotal);
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Total:                                      $%.2f%n", total);
        System.out.println("==================================================");
    }
}
