package Java9;
import pojo.Book;
import java.sql.Array;
import  java.util.*;
//diamond operator was introduced in java 7 was enhanced in java 8
// we don't mention the generic type on the right hand side
class A
{
    void foo()
    {
        System.out.println("foo of class A");
    }
}
class B extends  A
{
    void foo()
    {
        System.out.println("foo of class B override");
    }
}
public class C_DiamondOp
{
    public static void main(String[] args)
    {
        //diamond operator
        List<Book> books=new ArrayList<>();
        books.add(new Book(1,"java",500));
        books.add(new Book(2,"python",300));
        books.add(new Book(3,"c++",400));
        books.add(new Book(4,"c",200));

        for(Book book:books)
        {
            book.read();
        }

    }
}
