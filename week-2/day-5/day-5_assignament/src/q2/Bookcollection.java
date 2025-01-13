package q2;

import java.util.ArrayList;

class BookCollection {
    private String ownerName;
    private ArrayList<Book> books;

    public BookCollection(String ownerName, ArrayList<Book> books) {
        this.ownerName = ownerName;
        this.books = books;
    }

    // Getters and setters
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    // toString method to output the collection details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book Collection of " + ownerName + ":\n");
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }
}