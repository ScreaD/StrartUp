package ua.com.scread.controller;

import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import ua.com.scread.model.Category;
import ua.com.scread.service.ProjectsService;

import java.util.List;

public class CategoriesAction implements ModelDriven {

	private Category category;

	@Autowired
	private ProjectsService service;

	private List<Category> categories;

	@Override
	public Object getModel() {
		return category;
	}

	public String getAll() throws Exception {
		categories = service.getCategories();
		return "success";
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
