package ua.com.scread.model;

import java.util.List;

public interface Categories {

	int add(Category category);
	
	List<Category> getAll();
	
	Category get(int id);

	int size();

}