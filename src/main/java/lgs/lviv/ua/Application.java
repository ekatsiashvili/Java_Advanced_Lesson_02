package lgs.lviv.ua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import lgs.lviv.ua.Author;

public class Application {

	public static int menu() {
		System.out.println();
		System.out.println("-----Standart data-----");
		System.out.println("Please input 11 for standart data");
		System.out.println("-----Book's database-----");
		System.out.println("Please input 21 for add book into the database");
		System.out.println("Please input 22 for delete book from the database by id");
		System.out.println("Please input 23 for add additional data about the book by id");
		System.out.println("Please input  24 for view all books");
		System.out.println("-----Author's database-----");
		System.out.println("Please input 31 for add author into the database");
		System.out.println("Please input 32 for delete author from database by id");
		System.out.println("Please input 33 for add additional data about the author by id");
		System.out.println("Please input 34 for view all authors");
		System.out.println("-----Category books database-----");
		System.out.println("Please input 41 for add book's category into tha database");
		System.out.println("Please input 42 for delete book's category from database by id");
		System.out.println("Please input 43 for add additional data about the book's category by id");
		System.out.println("Please input 44 for view all books category");
		System.out.println("------Exit out of the program------");
		System.out.println("Please input 0 for exit");
		System.out.println();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please make your choice:");
		int menuChoise = scanner.nextInt();

		return menuChoise;
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {

		AuthorDAO authorDAO = new AuthorDAO(ConnectionUtils.openConnection());
		BookDAO bookDAO = new BookDAO(ConnectionUtils.openConnection());
		CategoryBookDAO categoryBookDAO = new CategoryBookDAO(ConnectionUtils.openConnection());

		while (true) {
			switch (menu()) {

			case 11: {
				List<Author> authorsList = Author.createDefaultData();

				authorsList.stream().forEach(author -> {
					try {
						authorDAO.insert(author);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});

				authorDAO.readAll().forEach(System.out::println);
				System.out.println("================================================");
				System.out.println();

				List<Book> booklList = Book.createDefaultData();

				booklList.stream().forEach(book -> {
					try {
						bookDAO.insert(book);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});

				bookDAO.readAll().forEach(System.out::println);
				System.out.println("================================================");
				System.out.println();

				List<CategoryBook> categoryBookList = CategoryBook.createDefaultData();

				categoryBookList.stream().forEach(categoryBook -> {
					try {
						categoryBookDAO.insert(categoryBook);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});

				categoryBookDAO.readAll().forEach(System.out::println);
				System.out.println("================================================");
				System.out.println();

				break;
			}

			case 21: {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please input the name of book:");
				String bookName = reader.readLine();
				System.out.println("Please input book's description:");
				String bookDescription = reader.readLine();;
				System.out.println("Please input the price of the book (format example: 999.99):");
				Double price = Double.parseDouble(reader.readLine());
				System.out.println("Please input book's ISBN:");
				String isbn = reader.readLine();
				Book book = new Book(bookName, bookDescription, price, isbn);
				bookDAO.insert(book);
				break;
			}

			case 22: {
				bookDAO.readAll().forEach(System.out::println);
				System.out.println("Please input id for delete:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				bookDAO.delete(id);
				
				break;
			}

			case 23: {
				System.out.println("Please input id for search:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				Book bookFromDB = bookDAO.read(id);
				System.out.println(bookFromDB.toString());
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please input the date for change the name of the book:");
				String bookName = reader.readLine();
				System.out.println("Please input the date for change the description of the book:");
				String bookDescription = reader.readLine();
				System.out.println("Please input the date for change the price of the book(в форматі 999.99):");
				double price = Double.parseDouble(reader.readLine());
				System.out.println("Please input the date for change ISBN of the book:");
				String isbn = reader.readLine();
				
				if (bookName.equals("")) {
					bookFromDB.setBookName(bookFromDB.getBookName());
				} else {
					bookFromDB.setBookName(bookName);
				}
				
				if (bookDescription.equals("")) {
					bookFromDB.setBookDescription(bookFromDB.getBookDescription());
				} else {
					bookFromDB.setBookDescription(bookDescription);
				}
				
				if (price == 0.0) {
					bookFromDB.setPrice(bookFromDB.getPrice());
				} else {
					bookFromDB.setPrice(price);
				}
				
				if (isbn.equals("")) {
					bookFromDB.setIsbn(bookFromDB.getIsbn());
				} else {
					bookFromDB.setIsbn(isbn);
				}
				
				bookDAO.update(bookFromDB);
				break;
			}

			case 24: {
				bookDAO.readAll().forEach(System.out::println);
				break;
			}

			case 31: {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please input author's First name:");
				String firstName = reader.readLine();
				System.out.println("Please input author's Last name:");
				String lastName = reader.readLine();
				System.out.println("Please input author's e-mail:");
				String email = reader.readLine();
				System.out.println("Please input author's address:");
				String address = reader.readLine();
				System.out.println("Please input author's the date of birthday:");
				int birthdayDate = Integer.parseInt(reader.readLine());
				Author author = new Author(firstName, lastName, email, address, birthdayDate);
				authorDAO.insert(author);
				break;
			}

			case 32: {
				authorDAO.readAll().forEach(System.out::println);
				System.out.println("Please input id for delete:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				authorDAO.delete(id);
				
				break;
			}
			case 33: {
				System.out.println("Please input id for search:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				Author authorFromDB = authorDAO.read(id);
				System.out.println(authorFromDB.toString());
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please input the data for change the author's First name:");
				String firstName = reader.readLine();
				System.out.println("Please input the data for change the author's Last name:");
				String lastName = reader.readLine(); 
				System.out.println("Please input the data for change the author's e-mail:");
				String email = reader.readLine();
				System.out.println("Please input the data for change the author's address");
				String address = reader.readLine();
				System.out.println("Please input the data for change the author's date of birth:");
				int year = Integer.parseInt(reader.readLine());
				if (firstName.equals("")) {
					authorFromDB.setFirstName(authorFromDB.getFirstName());
				} else {
					authorFromDB.setFirstName(firstName);
				}
				
				if (lastName.equals("")) {
					authorFromDB.setLastName(authorFromDB.getLastName());
				} else {
					authorFromDB.setLastName(lastName);
				}
				
				if (email.equals("")) {
					authorFromDB.setEmail(authorFromDB.getEmail());
				} else {
					authorFromDB.setEmail(email);
				}
				
				if (address.equals("")) {
					authorFromDB.setAddress(authorFromDB.getAddress());
				} else {
					authorFromDB.setAddress(address);
				}
				
				if (year == 0) {
					authorFromDB.setBirthdayDate(authorFromDB.getBirthdayDate());
				} else {
					authorFromDB.setBirthdayDate(year);
				}
				
				authorDAO.update(authorFromDB);
				break;
			}

			case 34: {
				authorDAO.readAll().forEach(System.out::println);
				break;
			}

			case 41: {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("Please input a title for the book genre:");
				String categoryName = sc.nextLine();
				CategoryBook categoryBook = new CategoryBook(categoryName);
				categoryBookDAO.insert(categoryBook);
				
				break;
			}

			case 42: {
				categoryBookDAO.readAll().forEach(System.out::println);
				System.out.println("Please input id for delete:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				categoryBookDAO.delete(id);
				
				break;
			}

			case 43: {
				System.out.println("Please input id for search:");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int id = sc.nextInt();
				CategoryBook categoryBookFromDB = categoryBookDAO.read(id);
				System.out.println(categoryBookFromDB.toString());
				System.out.println("Please input the data for change book's genre:");
				String categoryName = sc.nextLine();
				
				if (categoryName.equals("")) {
					categoryBookFromDB.setCategoryName(categoryBookFromDB.getCategoryName());
				} else {
					categoryBookFromDB.setCategoryName(categoryName);
				}
				
				categoryBookDAO.update(categoryBookFromDB);
				
				break;
			}

			case 44: {
				categoryBookDAO.readAll().forEach(System.out::println);
				break;
			}

			case 0: {
				System.out.println("Thank you for using our library. All the best! \\ n ");
				System.exit(0);
				break;
			}

			default: {
				System.out.println("There is no such item in the menu!");
				break;
			}
			}
		}
	}

}