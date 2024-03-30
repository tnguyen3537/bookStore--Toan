package Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository <Book,Long> {

}
