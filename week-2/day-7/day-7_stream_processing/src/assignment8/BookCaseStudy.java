package assignment8;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class BookCaseStudy
{
    public static void main(String[] args) {

        List<Book> allBooks = loadAllBooks();
        System.out.println("Question 1");
        // 1. Find books with more then 400 pages
        List<Book>booksMoreThen400Pages=allBooks.stream()
                .filter(b-> b.getPages()>400).collect(toList());
        System.out.println(booksMoreThen400Pages);
        System.out.println("=======================================================================");
        System.out.println("Question 2");
        // 2. Find all books that are java books and more then 400 pages
//        Predicate<Book> booksMoreThan400Pages = new Predicate<Book>() {
//            @Override
//            public boolean test(Book book) {
//                return book.getPages()>400;
//            }
//        };
        // this is using anonymous in a class
        Predicate<Book> booksMoreThan400Pages = (book)-> book.getPages()>400;
        // this the reduced lambda function
        Predicate<Book> isJavaBook = (book)-> book.getSubject().equals(Subject.JAVA);
        Predicate<Book> isJavaAndMoreThan400Pages=booksMoreThan400Pages.and(isJavaBook);
        List<Book>booksisJavaAndMoreThan400Pages=allBooks.stream()
                .filter(isJavaAndMoreThan400Pages).toList();
        booksisJavaAndMoreThan400Pages.forEach(System.out::println);



        System.out.println("=======================================================================");
        System.out.println("Question 3");
        // 3. We need the top three longest books
        List<Book>books3WiththeLongestNames=allBooks.stream().sorted(Comparator.comparingInt(Book::getPages).reversed()).skip(3).limit(3).toList();
        books3WiththeLongestNames.forEach(System.out::println);

        System.out.println("=======================================================================");
        System.out.println("Question 4");
        // 4. We need from the fourth to the last longest books
        List<Book>books4thToLastLongestNames=allBooks.stream().sorted(Comparator.comparingInt(Book::getPages).reversed()).skip(3).limit(3).toList();
        books3WiththeLongestNames.forEach(System.out::println);

        System.out.println("=======================================================================");
        System.out.println("Question 5");
        // 5. We need to get all the publishing years
        List<Integer>booksPublishingYears=allBooks.stream().map(Book::getYear).distinct().toList();
        booksPublishingYears.forEach(System.out::println);


        System.out.println("=======================================================================");
        System.out.println("Question 6");
        // 6. We need all the authors names who have written a book
        List<String> bookAuthor=allBooks.stream().flatMap(book -> book.getAuthors().stream()).map(Author::getName).distinct().toList();
        bookAuthor.forEach(System.out::println);



        System.out.println("=======================================================================");
        System.out.println("Question 7");
        // We need all the origin countries of the authors
        List<String> bookAuthorOriginCountries=allBooks.stream().flatMap(book -> book.getAuthors().stream()).map(Author::getCountry).distinct().toList();
        bookAuthorOriginCountries.forEach(System.out::println);



        System.out.println("=======================================================================");
        System.out.println("Question 8");
        // We want the most recent published book
        List<Integer>booksRecentPublishingYears=allBooks.stream().sorted(Comparator.comparingInt(Book::getYear).reversed()).map(Book::getYear).limit(1).toList();
        booksRecentPublishingYears.forEach(System.out::println);



        System.out.println("=======================================================================");
        System.out.println("Question 9");
        // We want the most recent published book
        List<String> booksRecentPublishingBook=allBooks.stream().sorted(Comparator.comparingInt(Book::getYear).reversed()).map(Book::getTitle).limit(1).toList();
        booksRecentPublishingBook.forEach(System.out::println);


        System.out.println("=======================================================================");
        System.out.println("Question 10");
        // We want to know if all the books are written by more than one author
        //List<String> booksWrittrenByMoreThanOneUser=allBooks.stream().flatMap(book -> book.getAuthors().stream()).map(Author author->author.length()).toList();
        boolean booksWrittrenByMoreThanOneUser=allBooks.stream().allMatch(book -> book.getAuthors().size()>=2);
        System.out.println(booksWrittrenByMoreThanOneUser);
        // not all the books are written by more than one author
        // as the book python was only written by one author raj



        System.out.println("=======================================================================");
        System.out.println("Question 11");
        // We want one of the books written by more than one author. (findAny)
        //List<Integer> booksWrittrenByMoreThanOneUser=allBooks.stream().flatMap(book -> book.getAuthors()
        Optional<Book> ifAnyBookWrittrenByMoreThanOneUser=allBooks.stream().findAny().filter(book -> book.getAuthors().size()>=2);
        System.out.println(ifAnyBookWrittrenByMoreThanOneUser);



        System.out.println("=======================================================================");
        System.out.println("Question 12");
        // We want the total number of pages published.
        int totalNumberOfPages = allBooks.stream().mapToInt(Book::getPages).sum();
        System.out.println(totalNumberOfPages);
        // sum is exclusive to primitive streams
        // else have to use reduce
        int totalNumberOfPagesWithReduce = allBooks.stream().mapToInt(Book::getPages).reduce(0, (a, b) -> a + b);
        System.out.println(totalNumberOfPagesWithReduce);




        System.out.println("=======================================================================");
        System.out.println("Question 13");
        // We want to know how many pages the longest book has.
        int longestBookPages = allBooks.stream().mapToInt(Book::getPages).max().getAsInt();
        System.out.println(longestBookPages);




        System.out.println("=======================================================================");
        System.out.println("Question 14");
        // We want the average number of pages of the books
        IntSummaryStatistics averageNumberOfPages = allBooks.stream().mapToInt(Book::getPages).summaryStatistics();
        System.out.println(averageNumberOfPages.getAverage());



        System.out.println("=======================================================================");
        System.out.println("Question 15");
        // We want all the titles of the books
        List<String> bookAllTitles = allBooks.stream().map(Book::getTitle).toList();
        bookAllTitles.forEach(System.out::println);







        System.out.println("=======================================================================");
        System.out.println("Question 16");
        // We want the book with the higher number of authors?
        int highestNumberOfAuthors = allBooks.stream().sorted(Comparator.comparing(book -> book.getAuthors().size())).mapToInt(book -> book.getAuthors().size()).max().getAsInt();
        System.out.println(highestNumberOfAuthors);



        System.out.println("=======================================================================");
        System.out.println("Question 17");
        // We want a Map of book per year.
        Map<Integer, List<Book>> bookPerYear = allBooks.stream().collect(Collectors.groupingBy(Book::getYear));
        bookPerYear.entrySet().forEach(new Consumer<Map.Entry<Integer, List<Book>>>() {
            @Override
            public void accept(Map.Entry<Integer, List<Book>> integerListEntry) {
                System.out.println(integerListEntry.getKey()+"_____"+integerListEntry.getValue());
            }
        });




        System.out.println("=======================================================================");
        System.out.println("Question 18");
        // We want to count how many books are published per year.
        Map<Integer, Long> bookPerYearCount = allBooks.stream().collect(Collectors.groupingBy(Book::getYear, Collectors.counting()));
        bookPerYearCount.entrySet().forEach(new Consumer<Map.Entry<Integer, Long>>() {
            @Override
            public void accept(Map.Entry<Integer, Long> integerLongEntry) {
                System.out.println(integerLongEntry.getKey()+"_____"+integerLongEntry.getValue());
            }
        });


    }




        private static List<Book> loadAllBooks() {
            List<Book> books = new ArrayList<Book>();
            List<Author> authors1 = Arrays.asList(new Author("raj", "gupta", "in"),
                    new Author("ekta", "gupta", "in"));

            List<Author> authors2 = Arrays.asList(new Author("raj", "gupta", "in"));

            List<Author> authors3 = Arrays.asList(new Author("gunika", "gupta", "us"),
                    new Author("keshav", "gupta", "us"));

            books.add(new Book("java", authors1, 400, Subject.JAVA, 2000, "1213"));
            books.add(new Book("python", authors2, 479, Subject.JAVA, 2007, "1218"));
            books.add(new Book("Mgt", authors3, 600, Subject.DOT_NET, 2000, "1293"));
            books.add(new Book("ruby", authors3, 300, Subject.DOT_NET, 2000, "1294"));

            return books;
        }
    }