package Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import Bookstore.domain.Book;
import Bookstore.domain.BookRespository;
import Bookstore.domain.Category;
import Bookstore.domain.CategoryRepository;

//@DataJpaTest

//@ExtendWith(SpringExtension.class)
// @SpringBootTest(classes = BookstoreApplication.class)
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// public class BookRepositoryTest {

//     @Autowired
//     private BookRespository brepository;

//     @Autowired
//     private CategoryRepository crepository;

//     @Test
//     public void findByAuthorShouldReturnBook() {
//         List<Book> books = brepository.findByAuthor("A Famous Authour");
        
//         assertThat(books).hasSize(1);
//         assertThat(books.get(0).getAuthor()).isEqualTo("A Famous Authour");
//     }
    
//     @Test
//     public void createNewBook() {
//     	Category category = new Category("Funny");
//     	crepository.save(category);
//     	Book book = new Book(242144, "A Random Book", "Not Me", 1960, category,20.50);
//     	brepository.save(book);
//     	assertThat(book.getId()).isNotNull();

//     }    
//     @Test
//     public void deleteNewBook() {
//         List<Book> books = brepository.findByAuthor("Not Me");
//         Book book = books.get(0);
// 		brepository.delete(book);
// 		List<Book> newBooks = brepository.findByAuthor("Not Me");
// 		assertThat(newBooks).hasSize(0);
//      }
// }
