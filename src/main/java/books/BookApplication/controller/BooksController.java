package books.BookApplication.controller;

import books.BookApplication.domain.Books;
import books.BookApplication.repository.BookRepository;
import books.BookApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/books")
public class BooksController {
    @Autowired
    public BookService bookService;
    @Autowired
    public BookRepository bookRepository;
    @GetMapping
    public List<Books>  getAllBooks(){
        return bookService.getAllBooks();

    }
    @GetMapping("/{isbn}")
    public Books getBookByIsbn(@PathVariable ("isbn") String isbn){
        return bookService.getBook(isbn);
    }
    @PostMapping
    public void addBooks(@RequestBody Books book){
        bookService.addBooks(book);
    }
    @DeleteMapping("/{isbn}")
    public void deleteBooks(@PathVariable String isbn){
        bookService.deleteBooks(isbn);
    }
    @PutMapping("/{isbn}")
    public ResponseEntity<Books> updateBook(@PathVariable String isbn, @RequestBody Books updatedBook) {
        Books book = bookService.updateBook(isbn, updatedBook);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
