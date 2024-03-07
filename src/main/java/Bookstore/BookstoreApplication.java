package Bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Bookstore.domain.BookRespository;
import Bookstore.domain.AppUser;
import Bookstore.domain.AppUserRepository;
import Bookstore.domain.Book;
import Bookstore.domain.Category;
import Bookstore.domain.CategoryRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRespository brepository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {

			Category c1 = new Category("Funny");
			Category c2 = new Category("Sad");
			Category c3 = new Category("Super real expensive");

			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);

			Book b1 = new Book(1231312, "Diary of a famous person", "A Famous Authour", 2003, c2, 100);
			Book b2 = new Book(1231311, "Life of a bug", "Antman", 2012, c1, 150);
			Book b3 = new Book(1231316, "History of the universe", "Creater of the universe", 2022, c3, 1000000);

			brepository.save(b1);
			brepository.save(b2);
			brepository.save(b3);

				// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};
	}

}
