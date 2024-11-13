package me.nijul.rmg;

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

    void updateStock(int quantity) {

    }

    double calculateDiscountPrice(double discountPercentage) {

        return 0;
    }
}

class Fabric {

    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    public double calculateCost(double meters) {

        return 0;
    }
}

class Supplier {

    public String id;
    public String name;
    public String contactInfo;
    private List<Fabric> suppliedFabrics;

    public void addFabric(Fabric fabric) {

    }

    public List<Fabric> getSuppliedFabrics() {

        return suppliedFabrics;

    }
}

class Order {

    public String orderId;
    public Date orderDate;
    public List<Garment> garments;
    public double totalAmount;

    public void addGarment(Garment garment) {

    }

    public double calculateTotalAmount() {

        return 0;
    }

    void printOrderDetails() {

    }
}

class Customer {

    public String customerId;
    public String name;
    public String email;
    public String phone;

    public void placeOrder(Order order) {

    }

    public List<Order> viewOrders() {
        return null;
    }
}

class Inventory {

    public List<Garment> garments;

    public void addGarment(Garment garment) {

    }

    public void removeGarment(String id) {

    }

    public Garment findGarment(String id) {

        return null;
    }
}

public class Rmg {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}