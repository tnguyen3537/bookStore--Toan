package Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Bookstore.domain.BookRespository;

@Controller
public class BookController {
	@Autowired
	private BookRespository repository;

	@GetMapping("booklist")
	public String getInfo(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

}
