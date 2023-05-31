package books;

import java.util.Collection;

public class Bookss {
    private Collection<Books> books;

    public Bookss(Collection<Books> books) {
        this.books = books;
    }

    public Bookss() {
    }

    public Collection<Books> getBooks() {
        return books;
    }

    public void setBooks(Collection<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Bookss{" +
                "books=" + books +
                '}';
    }
}
