package books.BookApplication.service.Impl;

import books.BookApplication.domain.Books;
import books.BookApplication.integration.JmsSender;
import books.BookApplication.repository.BookRepository;
import books.BookApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BookServiceImpl implements BookService {
    @Autowired
    public BookRepository bookRepository;
    @Autowired
    public JmsSender jmsSender;
    @Override
    public void addBooks(Books book) {
         bookRepository.save(book);
         jmsSender.sendMessage(book);
    }



    public Books getBook(String isbn) {
        jmsSender.sendMessageForDelete(isbn);
        return bookRepository.findByIsbn(isbn);

             //   .orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));
    }


    @Override
    public List<Books> getAllBooks() {
    return bookRepository.findAll();
    }

    @Override
    public void deleteBooks(String isbn) {
        jmsSender.sendMessageForDelete(isbn);
        bookRepository.deleteByIsbn(isbn);
    }



    @Override
    public Books updateBook(String isbn, Books updatedBook) {
        Books existingBook = bookRepository.findByIsbn(isbn);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            jmsSender.sendMessage(existingBook);
            return bookRepository.save(existingBook);
        }
        return null;
    }
}
