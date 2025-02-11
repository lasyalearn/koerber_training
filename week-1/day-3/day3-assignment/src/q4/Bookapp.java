package q4;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Bookapp
{
    public static void main(String[] args)
    {
        ArrayList<Book> Books= new ArrayList<>();
        String line=null;
        // add finally try and catch
        try(BufferedReader br=new BufferedReader(new FileReader("book")))
        {
            while((line=br.readLine())!=null)
            {
                String arr[]=line.split(":");
                Books.add( new Book(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],Integer.parseInt(arr[4])));
            }
            for(Book book: Books)
            {
                String s=book.toString();
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("File Not Found Exception");
        }catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("IO Exception");
        }
        //search book
        try
        {
            System.out.println("Enter the book id that need to searched");
            Scanner sc=new Scanner(System.in);
            int book_id=sc.nextInt();
            Book book_found = Bookmethods.searchBook(book_id,Books);
            String s=book_found.toString();
            System.out.println(s);
        } catch (BookNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        //sell book
        try
        {   
            System.out.println("Enter the book id that need to be sold");
            Scanner sc=new Scanner(System.in);
            int book_id=sc.nextInt();
            System.out.println("Enter the book isbn that need to be sold");
            String isbn=sc.next();
            System.out.println("Enter the book copies that need to be sold");
            int noofcopies=sc.nextInt();
            Bookmethods.sellBook(isbn,book_id,noofcopies,Books);
            
            
        }catch(BookNotFoundException e){
            System.out.println(e.getMessage());
        }catch(NotSufficientBookException e){
            System.out.println(e.getMessage());
        }
        // till now we have read and the books int file and  created a books arrayList
        // first function we are going to implements is search by book id
        // if book is found the we can return the book object
        // if not found then we can return null
        // what could be  the execption handling here

        // ordering book
        Scanner sc= new Scanner(System.in);
        System.out.println("ordering books");
        System.out.println("Enter the book isbn that need to be sold");
        String isbn=sc.next();
        System.out.println("Enter the book copies that need to be sold");
        int noofcopies=sc.nextInt();
        Bookmethods.purchaseBook(isbn,noofcopies,Books);
        for(Book book: Books)
        {
            String s=book.toString();
            System.out.println(s);
        }
        // book not found is already handles so there is no exception handling for this




        // First try code without try catch

//        BufferedReader br= new BufferedReader(new FileReader("book"));
//        while((line=br.readLine())!=null)
//        {
//            String arr[]=line.split(":");
//            Books.add( new Book(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],Integer.parseInt(arr[4])));
//        }
//        for(Book book: Books)
//        {
//            String s=book.toString();
//            System.out.println(s);
//        }
        //br.close();


    }
}
