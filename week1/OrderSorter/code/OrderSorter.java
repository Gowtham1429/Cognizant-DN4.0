import java.util.Scanner;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void display() {
        System.out.println(orderId + " - " + customerName + " - " + totalPrice);
    }
}

public class OrderSorter {
    static Order[] orders = {
        new Order(201, "Alice", 1500.0),
        new Order(202, "Bob", 850.0),
        new Order(203, "Charlie", 1200.0),
        new Order(204, "David", 2000.0),
        new Order(205, "Eva", 900.0)
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Orders before sorting:");
        printOrders(orders);

        System.out.println("\n1. Bubble Sort\n2. Quick Sort");
        int choice = sc.nextInt();

        if (choice == 1) {
            bubbleSort(orders.clone());
        } else if (choice == 2) {
            Order[] cloned = orders.clone();
            quickSort(cloned, 0, cloned.length - 1);
            System.out.println("\nOrders after Quick Sort:");
            printOrders(cloned);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    static void bubbleSort(Order[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("\nOrders after Bubble Sort:");
        printOrders(arr);
    }

    static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice < pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void printOrders(Order[] arr) {
        for (Order o : arr) {
            o.display();
        }
    }
}
