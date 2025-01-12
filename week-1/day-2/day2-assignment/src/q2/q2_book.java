package q2;

public class q2_book
{
        public static class Book
        {
            private String bookTitle;
            private String author;
            private String ISBN;
            private int numofCopies;
            Book(String bookTitle, String author, String ISBN, int numofCopies)
            {
                this.bookTitle=bookTitle;
                this.author=author;
                this.ISBN=ISBN;
                this.numofCopies=numofCopies;
            }
            public String getBookTitle()
            {
                return bookTitle;
            }
            public String getAuthor()
            {
                return author;
            }
            public String getIsbn()
            {
                return ISBN;
            }
            public int getNumofCopies()
            {
                return numofCopies;
            }
            public void setNumofCopies(int numofCopies)
            {
                this.numofCopies=numofCopies;
            }
            public void display()
            {
                System.out.println("Bookname: "+bookTitle);
                System.out.println("Author: "+author);
                System.out.println("ISBN: "+ISBN);
                System.out.println("No.of.copies: "+numofCopies);
            }
        }
}
