package lgs.lviv.ua;

import java.util.ArrayList;
import java.util.List;

public class CategoryBook {

	private int id;
	private String categoryName;

	public CategoryBook(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public CategoryBook(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return id + " --- Name of Category - " + "\"" + categoryName + "\"";
	}

	public static List<CategoryBook> createDefaultData() {
		List<CategoryBook> categoryBookList = new ArrayList<>();
		categoryBookList.add(new CategoryBook("Fantasy"));
		categoryBookList.add(new CategoryBook("Picture book"));
		categoryBookList.add(new CategoryBook("Fairy tale"));
		categoryBookList.add(new CategoryBook("Fantasy"));
		categoryBookList.add(new CategoryBook("Romantic novel"));
		return categoryBookList;
	}

}