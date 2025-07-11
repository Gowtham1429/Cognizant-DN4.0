import java.util.HashMap;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println(productId + " - " + productName + " - " + quantity + " - " + price);
    }
}

public class InventoryManager {
    static HashMap<Integer, Product> inventory = new HashMap<Integer, Product>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. Display All\n5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addProduct(); break;
                case 2: updateProduct(); break;
                case 3: deleteProduct(); break;
                case 4: displayProducts(); break;
                case 5: System.exit(0);
            }
        }
    }

    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        inventory.put(id, new Product(id, name, qty, price));
    }

    static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        if (inventory.containsKey(id)) {
            sc.nextLine();
            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            System.out.print("Enter New Quantity: ");
            int qty = sc.nextInt();
            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();
            inventory.put(id, new Product(id, name, qty, price));
        } else {
            System.out.println("Product not found.");
        }
    }

    static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();
        if (inventory.containsKey(id)) {
            inventory.remove(id);
        } else {
            System.out.println("Product not found.");
        }
    }

    static void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                p.display();
            }
        }
    }
}
