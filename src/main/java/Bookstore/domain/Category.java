package Bookstore.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	private String cName;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;

	public Category() {
	
	}

	public Category(String cName) {
		super();
		
		this.cName = cName;
	}

	public Long getcid() {
		return cid;
	}

	public void setcid(Long id) {
		this.cid = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setStudents(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cName=" + cName + "]";
	}

}
