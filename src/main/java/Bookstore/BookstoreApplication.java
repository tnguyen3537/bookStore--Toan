package Bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Bookstore.domain.BookRespository;
import Bookstore.domain.Book;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRespository repository) {
	return (args) -> {
		
		Book b1 = new Book (1231312, "Diary of a famous person", "A Famous Authour", 2003, 100);
		Book b2 = new Book (1231311, "Life of a bug", "Antman", 2012, 150);
		Book b3 = new Book (1231316, "History of the universe", "Creater of the universe", 2022, 1000000);
		
		repository.save(b1);
		repository.save(b2);
		repository.save(b3);
		
		
	};
	}

}
