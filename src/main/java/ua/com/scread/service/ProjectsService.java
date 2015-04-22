package ua.com.scread.service;

import ua.com.scread.model.Category;
import ua.com.scread.model.Project;

import java.util.List;

public interface ProjectsService {

	List<Category> getAllWithProjects();

	Category getWithProjects(int id);

	Project getProject(int id);

	List<Category> getCategories();

}
