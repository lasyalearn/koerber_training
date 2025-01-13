package q2;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Book Collection");
        System.out.println("----------------");

        System.out.println("Enter the Owner name");
        String ownerName = sc.nextLine();
        System.out.println("----------------");

        System.out.println("Enter the number of books owned by the owner");
        int noOfBooks = sc.nextInt();
        sc.nextLine();  // consume the newline character

        ArrayList<q2.Book> books = new ArrayList<>();
        for (int i = 0; i < noOfBooks; i++) {
            System.out.println("Enter the title of the book");
            String title = sc.nextLine();
            System.out.println("Enter the author of the book");
            String author = sc.nextLine();
            q2.Book book = new q2.Book(title, author);
            books.add(book);
        }

        // Create a BookCollection object
        BookCollection bookCollection = new BookCollection(ownerName, books);
        System.out.println("----------------");
        System.out.println(bookCollection);
        System.out.println("----------------");

        // Search for a book
        System.out.println("Enter the title of the book you want to search for");
        String titleSearch = sc.nextLine();
        System.out.println("Enter the author of the book you want to search for");
        String authorSearch = sc.nextLine();

        q2.Book bookSearch = new q2.Book(titleSearch,authorSearch);
        boolean isPresent = BookMethods.hasBook(bookSearch,books);
        if (isPresent) {
            System.out.println("The book is present");
        } else {
            System.out.println("The book is not present");
        }

        System.out.println("----------------");

        // Sort the books by title and author
        books.sort(new SortByTitleAndAuthor());

        // Output the sorted BookCollection
        System.out.println("Sorted Book Collection:");
        System.out.println(bookCollection);
    }
}