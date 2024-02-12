package Bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int isbn;
	private String title, author;
	private int bookyear;
	private double price;

	@ManyToOne
	@JoinColumn(name = "cid")
	private Category category;

	public Book() {
	}

	public Book(int isbn, String title, String author, int bookyear, Category category, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.bookyear = bookyear;
		this.category = category;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;

	}

	public int getBookyear() {
		return bookyear;
	}

	public void setBookyear(int year) {
		this.bookyear = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", year="
					+ bookyear + ", price=" + price + this.category.getcName() + "]";
		else
			return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", year="
					+ bookyear + ", price=" + price + "]";
	}

}
