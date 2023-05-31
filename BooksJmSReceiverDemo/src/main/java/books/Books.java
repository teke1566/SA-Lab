package books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private String id;
    private String isbn;
    private String  title;
    private String author;
    private String price;
    public Books(String isbn) {
        this.isbn = isbn;
    }
    public Books(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = String.valueOf(price);
    }

}
