package books;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class Books {

    private String isbn;
    private String title;
    private String author;
    private double price;

    public Books() {
    }

    public Books(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
