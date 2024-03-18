package Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import Bookstore.domain.Category;
import Bookstore.domain.CategoryRepository;

//@DataJpaTest

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository crepository;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = crepository.findBycName("Funny");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getcName()).isEqualTo("Funny");
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Fiction");
    	crepository.save(category);

    	assertThat(category.getcid()).isNotNull();
    }    

    @Test
    public void deleteNewCategory() {
        List<Category> categories = crepository.findBycName("Fiction");
        Category category = categories.get(0);
		crepository.delete(category);
		List<Category> newCategories = crepository.findBycName("Fiction");
		assertThat(newCategories).hasSize(0);
     }
}