package lgs.lviv.ua;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private int id;
	private String bookName;
	private String bookDescription;
	private double price;
	private String isbn;

	public Book(int id, String bookName, String bookDescription, double price, String isbn) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.price = price;
		this.isbn = isbn;
	}

	public Book(String bookName, String bookDescription, double price, String isbn) {
		super();
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.price = price;
		this.isbn = isbn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return id + " --- Name of book - " + "\"" + bookName + "\"" + ", description - " + "\"" + bookDescription + "\"" + ", price - " + price
				+ ", isbn - " + isbn;
	}
	
	public static List<Book> createDefaultData() {
		List<Book> booklList = new ArrayList<>();
		booklList.add(new Book("Alice in Wonderland", "Language: English", 900.00, "879-567-983-254-1"));
		booklList.add(new Book("Karlson", "Language: English", 897.00, "567-345-234-121-9"));
		booklList.add(new Book("Polyanna", "Language: English", 768.00, "567-321-564-345-9"));
		booklList.add(new Book("Kiki's delivery service", "Language: English", 590.00, "453-765-435-764-0"));
		booklList.add(new Book("Gone with the Wind", "Language: English", 760.00, "343-657-345-654-2"));
		return booklList;
	} 

}