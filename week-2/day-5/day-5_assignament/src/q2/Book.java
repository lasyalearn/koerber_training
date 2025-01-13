package q2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


class Book {
    private String title;
    private String author;

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Override toString to display book info
    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author;
    }

    // Override equals to compare by title and author
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return title.equals(book.title) && author.equals(book.author);
        }
        return false;
    }
}