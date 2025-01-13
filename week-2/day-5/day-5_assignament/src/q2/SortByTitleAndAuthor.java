package q2;

import java.util.Comparator;

class SortByTitleAndAuthor implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        int compareTitle = b1.getTitle().compareTo(b2.getTitle());
        if (compareTitle != 0) {
            return compareTitle;
        }
        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}