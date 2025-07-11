import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println(bookId + " - " + title + " - " + author);
    }
}

public class LibraryManager {
    static Book[] books = {
        new Book(1, "Data Structures", "Narasimha Karumanchi"),
        new Book(2, "Clean Code", "Robert C. Martin"),
        new Book(3, "Introduction to Algorithms", "CLRS"),
        new Book(4, "Effective Java", "Joshua Bloch"),
        new Book(5, "Head First Java", "Kathy Sierra")
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book title to search (Linear): ");
        String title = sc.nextLine();
        linearSearch(title);

        Arrays.sort(books, new Comparator<Book>() {
            public int compare(Book a, Book b) {
                return a.title.compareToIgnoreCase(b.title);
            }
        });

        System.out.print("Enter book title to search (Binary): ");
        title = sc.nextLine();
        binarySearch(title);
    }

    static void linearSearch(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                b.display();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Book not found (Linear Search)");
    }

    static void binarySearch(String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = title.compareToIgnoreCase(books[mid].title);
            if (cmp == 0) {
                books[mid].display();
                return;
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("Book not found (Binary Search)");
    }
}
