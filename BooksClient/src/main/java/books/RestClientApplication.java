package books;

import books.Books;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String serverUrl = "http://localhost:8080/api/v1/books";
		RestTemplate restTemplate = new RestTemplate();

		// Get all books
		ResponseEntity<Books[]> response = restTemplate.getForEntity(serverUrl, Books[].class);
		List<Books> books = Arrays.asList(response.getBody());
		System.out.println("All books:");
		for (Books book : books) {
			System.out.println(book);
		}

		// Get a book by ISBN
		String isbnToGet = "447665776";
		Books book = restTemplate.getForObject(serverUrl + "/" + isbnToGet, Books.class);
		System.out.println("Book retrieved: " + book);

		// Add a book
		Books bookToAdd = new Books("4476657756", "abe", "deadlife", 13.45);
		restTemplate.postForObject(serverUrl, bookToAdd, Void.class);

		// Update a book
		String bookIsbnToUpdate = "1234"; // Assuming you have the book ID for the book you want to update
		Books bookToUpdate = new Books(bookIsbnToUpdate, "fessdww", "abe",  19.99);
		restTemplate.put(serverUrl + "/" + bookIsbnToUpdate, bookToUpdate);

		// Delete a book
		String bookIsbnToDelete = "447665776";
		restTemplate.delete(serverUrl + "/" + bookIsbnToDelete);

		// Get all books after modifications
		response = restTemplate.getForEntity(serverUrl, Books[].class);
		books = Arrays.asList(response.getBody());
		System.out.println("All books after modifications:");
		for (Books b : books) {
			System.out.println(b);
		}
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
