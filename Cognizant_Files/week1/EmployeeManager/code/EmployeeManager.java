import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {
        System.out.println(employeeId + " - " + name + " - " + position + " - " + salary);
    }
}

public class EmployeeManager {
    static Employee[] employees = new Employee[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Employee\n2. Search Employee\n3. Traverse Employees\n4. Delete Employee\n5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addEmployee(); break;
                case 2: searchEmployee(); break;
                case 3: traverseEmployees(); break;
                case 4: deleteEmployee(); break;
                case 5: System.exit(0);
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Position: ");
        String position = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        employees[count++] = new Employee(id, name, position, salary);
    }

    static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                employees[i].display();
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    static void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
