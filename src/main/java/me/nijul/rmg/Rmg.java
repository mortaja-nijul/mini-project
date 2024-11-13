package me.nijul.rmg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    void updateStock(int quantity) {
        // To be implemented in later commits
    }

    double calculateDiscountPrice(double discountPercentage) {
        // To be implemented in later commits
        return 0;
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

    public double calculateCost(double meters) {
        // To be implemented in later commits
        return 0;
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

    public void addFabric(Fabric fabric) {
        // To be implemented in later commits
    }

    public List<Fabric> getSuppliedFabrics() {
        // To be implemented in later commits
        return suppliedFabrics;
    }
}

class Order {

    public String orderId;
    public Date orderDate;
    public List<Garment> garments;
    public double totalAmount;

    // Constructor
    public Order(String orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.garments = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addGarment(Garment garment) {
        // To be implemented in later commits
    }

    public double calculateTotalAmount() {
        // To be implemented in later commits
        return 0;
    }

    void printOrderDetails() {
        // To be implemented in later commits
    }
}

class Customer {

    public String customerId;
    public String name;
    public String email;
    public String phone;

    // Constructor
    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void placeOrder(Order order) {
        // To be implemented in later commits
    }

    public List<Order> viewOrders() {
        // To be implemented in later commits
        return null;
    }
}

class Inventory {

    public List<Garment> garments;

    // Constructor
    public Inventory() {
        this.garments = new ArrayList<>();
    }

    public void addGarment(Garment garment) {
        // To be implemented in later commits
    }

    public void removeGarment(String id) {
        // To be implemented in later commits
    }

    public Garment findGarment(String id) {
        // To be implemented in later commits
        return null;
    }
}

public class Rmg {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
