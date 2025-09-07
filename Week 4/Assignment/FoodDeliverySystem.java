public class FoodDeliverySystem {

    // FoodOrder class
    static class FoodOrder {
        String customerName;
        String foodItem;
        int quantity;
        double price;

        // Fixed rate per item
        final double fixedRate = 150.0;

        // 1. Default constructor → assigns "Unknown" order
        public FoodOrder() {
            this.customerName = "Unknown";
            this.foodItem = "None";
            this.quantity = 0;
            this.price = 0.0;
        }

        // 2. Constructor with food item → sets quantity = 1, price = default
        public FoodOrder(String foodItem) {
            this.customerName = "Guest";
            this.foodItem = foodItem;
            this.quantity = 1;
            this.price = fixedRate;
        }

        // 3. Constructor with food item and quantity → price = quantity × fixedRate
        public FoodOrder(String customerName, String foodItem, int quantity) {
            this.customerName = customerName;
            this.foodItem = foodItem;
            this.quantity = quantity;
            this.price = quantity * fixedRate;
        }

        // Method: printBill()
        public void printBill() {
            System.out.println("🍽️ Order Summary:");
            System.out.println("Customer Name : " + customerName);
            System.out.println("Food Item     : " + foodItem);
            System.out.println("Quantity      : " + quantity);
            System.out.println("Total Price   : ₹" + price);
            System.out.println("--------------------------------");
        }
    }

    // main method
    public static void main(String[] args) {
        // Order 1: Default order
        FoodOrder order1 = new FoodOrder();
        order1.printBill();

        // Order 2: Only food item (default quantity = 1)
        FoodOrder order2 = new FoodOrder("Burger");
        order2.printBill();

        // Order 3: Food item with quantity
        FoodOrder order3 = new FoodOrder("Alice", "Pizza", 2);
        order3.printBill();

        // Order 4: Another custom order
        FoodOrder order4 = new FoodOrder("Bob", "Pasta", 3);
        order4.printBill();
    }
}
