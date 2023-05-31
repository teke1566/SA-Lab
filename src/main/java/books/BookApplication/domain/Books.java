package books.BookApplication.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Document(collection = "books")
@Data
public class Books {
    @Id
    private String id;
    private String isbn;
    private String author;
    private String title;
    private double price;

    public Books(String isbn, String author, String title, double price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
    }
}
