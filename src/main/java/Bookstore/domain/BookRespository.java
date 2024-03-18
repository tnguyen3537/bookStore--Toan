package Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository <Book,Long> {

    List<Book> findByAuthor(String author);

}
