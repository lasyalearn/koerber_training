package q2;

import java.util.ArrayList;

public class BookMethods
{
    public static boolean hasBook(Book b, ArrayList<Book> books)
    {
        for(Book book:books)
        {
            if(book.equals(b))
            {
                return true;
            }
        }
        return false;
        //we throw an created exception
        //BookNotFoundException
    }


}
