package Bookstore.domain;

public class Book {
	
	private int isbn;
	private int year;
	private int price;
	private String title;
	private String author;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int isbn, int year, int price, String title, String author) {
		super();
		this.isbn = isbn;
		this.year = year;
		this.price = price;
		this.title = title;
		this.author = author;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", year=" + year + ", price=" + price + ", title=" + title + ", author=" + author
				+ "]";
	}
	
	
	

}
