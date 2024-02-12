package Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Bookstore.domain.BookRespository;
import Bookstore.domain.Book;

@Controller
public class BookController {
	@Autowired
	private BookRespository repository;

	@GetMapping("booklist")
	public String getInfo(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

	@GetMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	@PostMapping(value = "/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@PostMapping(value = "edit/save")
	public String saveEdit(Book book) {
		repository.save(book);
		return "redirect:../booklist";
	}

	@GetMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book",repository.findById(bookId));
		return "editbook";
	}

}
