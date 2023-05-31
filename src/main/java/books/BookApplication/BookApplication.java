package books.BookApplication;

import books.BookApplication.domain.Books;
import books.BookApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication  implements CommandLineRunner {
	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Books newBook=new Books("1234","teketsel"," life",12.45);
		Books newBook2=new Books("447665776","abe","Amazinglife",13.45);

		bookService.addBooks(newBook);
		bookService.addBooks(newBook2);


	}
}
