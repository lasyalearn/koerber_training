package q2;

import java.util.Scanner;

public class q2_tester
{
    public static void main(String[] args)
    {
        // we can also the bookstore name from the user
        // also the no of books in the book store
        q2_book_store.BookStore bookStore = new  q2_book_store.BookStore("koerber",3);
        bookStore.display();
        Scanner scanner= new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("Selling test");
        System.out.println("Enter the name of the book");
        String book_name= scanner.next();
        System.out.println("Enter the number of books:");
        int bookcopies_sold= scanner.nextInt();
        bookStore.sell(book_name,bookcopies_sold);
        bookStore.display();
        System.out.println("----------------------------------------------");
        System.out.println("ordering test");
        System.out.println("Enter the name of the book");
        book_name= scanner.next();
        System.out.println("Enter the number of books:");
        bookcopies_sold= scanner.nextInt();
        bookStore.order(book_name,bookcopies_sold);
        bookStore.display();

    }
}
