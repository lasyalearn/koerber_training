package q2;

import java.util.Scanner;

public class q2_book_store
{
    public static class BookStore {
        private int bookStoreSize;
        private int copies;
        private String bookStoreName;
        private q2_book.Book[] books;

        BookStore(String bookStoreName, int copies) {
            this.bookStoreName = bookStoreName;
            this.copies = copies;
            init();
        }

        private void init() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of books: ");
            bookStoreSize = scanner.nextInt();
            this.books = new q2_book.Book[10];

            for (int i = 0; i < bookStoreSize; i++) {
                System.out.println("Enter the name of the book: ");
                String name = scanner.next();
                System.out.println("Enter the author of the book: ");
                String author = scanner.next();
                System.out.println("Enter the ISBN of the book: ");
                String ISBN = scanner.next();
                books[i] = new q2_book.Book(name, author, ISBN, copies);
            }
        }

        public void sell(String bookTitle, int noOfCopies) {
            for (int i = 0; i < bookStoreSize; i++) {
                if (books[i].getBookTitle().equals(bookTitle)) {
                    if (books[i].getNumofCopies() >= noOfCopies) {
                        books[i].setNumofCopies(books[i].getNumofCopies() - noOfCopies);
                        System.out.println(noOfCopies + " copies sold.");
                        return;
                    } else {
                        System.out.println("Not enough copies available. Only " + books[i].getNumofCopies() + " in stock.");
                        return;
                    }
                }
            }
            System.out.println("Book not found.");
        }

        public void order(String bookTitle, int noOfCopies) {
            for (int i = 0; i < bookStoreSize; i++) {
                if (books[i].getBookTitle().equals(bookTitle)) {
                    books[i].setNumofCopies(books[i].getNumofCopies() + noOfCopies);
                    System.out.println(noOfCopies + " copies ordered.");
                    return;
                }
            }
            System.out.println("Book not found. Adding it to the bookstore.");
            if (bookStoreSize < books.length) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the author of the book: ");
                String author = scanner.next();
                System.out.println("Enter the ISBN of the book: ");
                String ISBN = scanner.next();
                books[bookStoreSize] = new q2_book.Book(bookTitle, author, ISBN, noOfCopies);
                bookStoreSize++;
            } else {
                System.out.println("No space left in the bookstore.");
            }
        }

        public void display()
        {
            System.out.println("Printing all the bookstore details--------------------");
            System.out.println("The bookstore name is " + bookStoreName);
            System.out.println("The no of books in the bookstore" + bookStoreSize);
            System.out.println("Printing all the book details-------------------------");
            for (int i = 0; i < bookStoreSize; i++) {
//                System.out.println("The book list is ");
//                System.out.println("Bookname: "+ books[i].getBookTitle());
//                System.out.println("Author: "+ books[i].getAuthor());
//                System.out.println("ISBN: "+books[i].getIsbn());
//                System.out.println("No.of.copies: "+books[i].getNumofCopies());
                books[i].display();
            }

        }
    }
}
