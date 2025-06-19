import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println(productId + " - " + productName + " - " + category);
    }
}

public class EcommerceSearch {
    static Product[] products = {
        new Product(101, "Laptop", "Electronics"),
        new Product(102, "Shoes", "Fashion"),
        new Product(103, "Book", "Stationery"),
        new Product(104, "Phone", "Electronics"),
        new Product(105, "Backpack", "Fashion")
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name to search (Linear): ");
        String target = sc.nextLine();
        linearSearch(target);

        Arrays.sort(products, new Comparator<Product>() {
            public int compare(Product a, Product b) {
                return a.productName.compareToIgnoreCase(b.productName);
            }
        });

        System.out.print("Enter product name to search (Binary): ");
        target = sc.nextLine();
        binarySearch(target);
    }

    static void linearSearch(String name) {
        boolean found = false;
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                p.display();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Product not found (Linear Search)");
    }

    static void binarySearch(String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = name.compareToIgnoreCase(products[mid].productName);
            if (cmp == 0) {
                products[mid].display();
                return;
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("Product not found (Binary Search)");
    }
}
