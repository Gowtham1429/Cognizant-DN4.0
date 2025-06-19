import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    void display() {
        System.out.println(taskId + " - " + taskName + " - " + status);
    }
}

public class TaskManager {
    static Task head = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Task\n2. Search Task\n3. Traverse Tasks\n4. Delete Task\n5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addTask(); break;
                case 2: searchTask(); break;
                case 3: traverseTasks(); break;
                case 4: deleteTask(); break;
                case 5: System.exit(0);
            }
        }
    }

    static void addTask() {
        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Task Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Status: ");
        String status = sc.nextLine();
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    static void searchTask() {
        System.out.print("Enter Task ID to search: ");
        int id = sc.nextInt();
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                temp.display();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    static void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }

    static void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }
        if (head.taskId == id) {
            head = head.next;
            System.out.println("Deleted successfully.");
            return;
        }
        Task prev = null;
        Task curr = head;
        while (curr != null && curr.taskId != id) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Task not found.");
        } else {
            prev.next = curr.next;
            System.out.println("Deleted successfully.");
        }
    }
}
