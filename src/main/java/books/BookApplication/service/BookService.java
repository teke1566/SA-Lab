package books.BookApplication.service;

import books.BookApplication.domain.Books;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
 void addBooks(Books book);
  Books getBook(String isbn);
  List<Books> getAllBooks();
  void deleteBooks(String isbn);




 Books updateBook(String isbn, Books updatedBook);
}
