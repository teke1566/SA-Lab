package books.BookApplication.repository;

import books.BookApplication.domain.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Books,String> {
    Books findByIsbn(String isbn);


    void deleteByIsbn(String isbn);

}
