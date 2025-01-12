package q4;

public class Book
{
    private int book_id;
    private String isbn;
    private String book_name;
    private String author;
    private int no_of_copies;
    Book(int book_id, String isbn, String book_name, String author, int no_of_copies)
    {
        this.book_id=book_id;
        this.isbn=isbn;
        this.book_name=book_name;
        this.author=author;
        this.no_of_copies=no_of_copies;
    }

    public Book(String s, String isbn, String bookName, String author, String s1) {
    }

    //getter
    public int getBookId()
    {
        return book_id;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public String getBook_name()
    {
        return book_name;
    }
    public String getAuthor()
    {
        return author;
    }
    public int getNo_of_copies()
    {
        return no_of_copies;
    }
    //setter
    public void setBookId(int book_id)
    {
        this.book_id=book_id;
    }
    public void getIsbn(String isbn)
    {
        this.isbn=isbn;
    }
    public void setBook_name(String book_name)
    {
        this.book_name=book_name;
    }
    public void setAuthor(String author)
    {
        this.author=author;
    }
    public void setNo_of_copies(int no_of_copies)
    {
        this.no_of_copies=no_of_copies;
    }
    @Override
    public String toString()
    {
        final StringBuilder book = new StringBuilder("{Book: ");
        book.append(" book_id= ").append(book_id);
        book.append(" ,book_isbn= ").append(isbn);
        book.append(" ,book_name= ").append(book_name);
        book.append(" ,book_author= ").append(author);
        book.append(" ,no_of_copies= ").append(no_of_copies).append("}");
        return book.toString();
    }

}
