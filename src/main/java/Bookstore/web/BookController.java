package Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Bookstore.domain.BookRespository;
import Bookstore.domain.CategoryRepository;
import Bookstore.domain.Book;

@Controller
public class BookController {

	@Autowired
	private BookRespository repository;
	@Autowired
	private CategoryRepository crepository;

	// Show all students
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

	@GetMapping(value={"/","booklist"})
	public String getInfo(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

	@GetMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}

	@PostMapping(value = "/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@GetMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}

	// RESTful service to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }  

	// RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findStudentRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }       

}
