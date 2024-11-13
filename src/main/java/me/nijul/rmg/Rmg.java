package me.nijul.rmg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Garment {

    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;

    // Constructor
    public Garment(String id, String name, String description, String size, String color, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Update the stock quantity of the garment
    void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }

    // Calculate the price after applying a discount percentage
    double calculateDiscountPrice(double discountPercentage) {
        return this.price - (this.price * discountPercentage / 100);
    }
}

class Fabric {

    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    // Constructor
    public Fabric(String id, String type, String color, double pricePerMeter) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.pricePerMeter = pricePerMeter;
    }

    // Calculate the cost based on the given meters of fabric
    public double calculateCost(double meters) {
        return meters * this.pricePerMeter;
    }
}

class Supplier {

    public String id;
    public String name;
    public String contactInfo;
    private List<Fabric> suppliedFabrics;

    // Constructor
    public Supplier(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.suppliedFabrics = new ArrayList<>();
    }

    // Add a fabric to the list of supplied fabrics
    public void addFabric(Fabric fabric) {
        this.suppliedFabrics.add(fabric);
    }

    // Get the list of supplied fabrics
    public List<Fabric> getSuppliedFabrics() {
        return suppliedFabrics;
    }
}

class Order {

    public String orderId;
    public Date orderDate;
    public List<Garment> garments;
    public double totalAmount;
    private double discountPercentage;

    // Constructor
    public Order(String orderId, Date orderDate, double discountPercentage) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.garments = new ArrayList<>();
        this.discountPercentage = discountPercentage;
        this.totalAmount = 0;
    }

    // Add a garment to the order
    public void addGarment(Garment garment) {
        garments.add(garment);
    }

    // Calculate the total amount for the order based on garments added
    public double calculateTotalAmount() {
        totalAmount = garments.stream().mapToDouble(g -> g.calculateDiscountPrice(discountPercentage)).sum();
        return totalAmount;
    }

    // Print the details of the order with discount details
    void printOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Total Amount after " + discountPercentage + "% discount: $" + totalAmount);
        System.out.println("Garments:");
        for (Garment g : garments) {
            double discountedPrice = g.calculateDiscountPrice(discountPercentage);
            System.out.println("- " + g.name + " (" + g.color + ", " + g.size + "): Original $" + g.price + ", Discounted $" + discountedPrice);
        }
    }
}

class Customer {

    public String customerId;
    public String name;
    public String email;
    public String phone;
    private List<Order> orders;

    // Constructor
    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.orders = new ArrayList<>();
    }

    // Place an order and add it to the customer's order list
    public void placeOrder(Order order) {
        orders.add(order);
    }

    // View the list of all orders placed by the customer
    public List<Order> viewOrders() {
        return orders;
    }
}

class Inventory {

    public List<Garment> garments;

    // Constructor
    public Inventory() {
        this.garments = new ArrayList<>();
    }

    // Add a garment to the inventory
    public void addGarment(Garment garment) {
        garments.add(garment);
    }

    // Remove a garment from the inventory by ID
    public void removeGarment(String id) {
        garments.removeIf(g -> g.id.equals(id));
    }

    // Find a garment in the inventory by ID
    public Garment findGarment(String id) {
        for (Garment g : garments) {
            if (g.id.equals(id)) {
                return g;
            }
        }
        return null; // Return null if the garment is not found
    }
}

public class Rmg {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Customer customer = new Customer("C001", "John Doe", "john@example.com", "1234567890");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nRMG Management System");
            System.out.println("1. Add Garment to Inventory");
            System.out.println("2. View Garments in Inventory");
            System.out.println("3. Add Order");
            System.out.println("4. View Customer Orders");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Garment to Inventory
                    System.out.print("Enter Garment ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Garment Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Size: ");
                    String size = scanner.nextLine();
                    System.out.print("Enter Color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int stockQuantity = scanner.nextInt();

                    Garment garment = new Garment(id, name, description, size, color, price, stockQuantity);
                    inventory.addGarment(garment);
                    System.out.println("Garment added to inventory.");
                    break;

                case 2:
                    // View Garments in Inventory
                    System.out.println("Garments in Inventory:");
                    for (Garment g : inventory.garments) {
                        System.out.println("- " + g.name + " (ID: " + g.id + ", Color: " + g.color + ", Size: " + g.size + ", Stock: " + g.stockQuantity + ")");
                    }
                    break;

                case 3:
                    // Add Order with Discount Confirmation
                    System.out.print("Enter Order ID: ");
                    String orderId = scanner.nextLine();
                    System.out.print("Enter discount percentage for this order: ");
                    double discountPercentage = scanner.nextDouble();
                    Order order = new Order(orderId, new Date(), discountPercentage);

                    while (true) {
                        System.out.print("Enter Garment ID to add to order (or type 'done' to finish): ");
                        String garmentId = scanner.next();
                        if (garmentId.equalsIgnoreCase("done")) break;

                        Garment garmentToAdd = inventory.findGarment(garmentId);
                        if (garmentToAdd == null || garmentToAdd.stockQuantity == 0) {
                            System.out.println("Garment not found or out of stock.");
                            continue;
                        }

                        System.out.print("Enter quantity to order: ");
                        int quantity = scanner.nextInt();
                        if (quantity > garmentToAdd.stockQuantity) {
                            System.out.println("Not enough stock available.");
                            continue;
                        }

                        garmentToAdd.updateStock(-quantity);
                        for (int i = 0; i < quantity; i++) {
                            order.addGarment(garmentToAdd);
                        }
                        System.out.println("Garment added to order.");
                    }

                    order.calculateTotalAmount();
                    System.out.printf("Order Total (after %.2f%% discount): $%.2f. Confirm? (yes/no): ", discountPercentage, order.totalAmount);
                    scanner.nextLine(); // Consume newline
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        customer.placeOrder(order);
                        System.out.println("Order placed successfully.");
                    } else {
                        System.out.println("Order cancelled.");
                    }
                    break;

                case 4:
                    // View Customer Orders
                    System.out.println("Customer Orders:");
                    for (Order o : customer.viewOrders()) {
                        o.printOrderDetails();
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
