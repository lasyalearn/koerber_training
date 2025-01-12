package q4;
import java.util.ArrayList;
public class Bookmethods
{
    //search book
    public  static Book searchBook(int book_id, ArrayList<Book> Books)
    {
        for(Book book:Books)
        {
            if(book.getBookId()==book_id)
            {
                System.out.println("Book found");
                //System.out.println(book.toString());
                return book;
            }
        }
        throw new BookNotFoundException("Book not found..of book id"+book_id);
    }
    //sell book able to handle if the number of copies are less then available copies
    public static void sellBook(String isbn, int book_id,int no_of_copies, ArrayList<Book> Books)
    {
        // first we need to check if book is there
        Book book_found = Bookmethods.searchBook(book_id,Books);
        //if book is not found u should be able to sell it
        // hence it BookNotFoundException should be extend from RuntimeException
        // unchecked
        // if it is checked then it should be throw new BookNotFoundException
        // it will cause a problem for sell unless we ask to enter again
        for(Book book:Books)
        {
            if(book.getBookId()==book_id)
            {
                if(book.getNo_of_copies()>=no_of_copies)
                {
                    // he should be able to sell
                    book.setNo_of_copies(book.getNo_of_copies()-no_of_copies);
                    System.out.println("sold: "+no_of_copies);
                    System.out.println("remaining left:"+book.getNo_of_copies());
                }
                else
                {
                    // we should throw NotsufficientBookException
                    throw new NotSufficientBookException("Not sufficient book ");
                }
            }
        }
    }
}
