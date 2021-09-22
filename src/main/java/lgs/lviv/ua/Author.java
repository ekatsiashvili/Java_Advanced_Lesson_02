package lgs.lviv.ua;

import java.util.ArrayList;
import java.util.List;

public class Author {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private int birthdayDate;

	public Author(int id, String firstName, String lastName, String email, String address, int birthdayDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.birthdayDate = birthdayDate;
	}

	public Author(String firstName, String lastName, String email, String address, int birthdayDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.birthdayDate = birthdayDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(int birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	@Override
	public String toString() {
		return id + " --- First name - " + "\"" + firstName + "\"" + ", last name - " + "\"" + lastName + "\"" + ", email - " + email
				+ ", address - " + "\"" + address + "\"" + ", date of birth - " + birthdayDate;
	}
	
	public static List<Author> createDefaultData() {
		List<Author> authorsList = new ArrayList<>();
		authorsList.add(new Author("Lyuis", "Karrol", "alisa1866@google.com", "Kuiv, Dal str, Ukraine", 1832));
		authorsList.add(new Author("Astrid", "Lingren", "peppy1945@google.com", "Lviv, oxford st, Ukraine", 1907));
		authorsList.add(new Author("Eleonor", "Porter", "pollyanna1907@google.com", "London, UK", 1868));
		authorsList.add(new Author("Eiko", "Kodonu", "eyko@google.com", "Kishinev, Moldova", 1938));
		authorsList.add(new Author("Margaret", "Mitchell", "margaret@mail.com", "Atlanta, Gorgiya, USA", 1900));
		return authorsList;
	} 

}
