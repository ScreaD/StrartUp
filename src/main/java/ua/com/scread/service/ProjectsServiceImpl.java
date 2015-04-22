package ua.com.scread.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.scread.dao.CategoriesDAO;
import ua.com.scread.dao.ProjectsDAO;
import ua.com.scread.model.Category;
import ua.com.scread.model.Project;

import java.util.List;

@Service
@Transactional
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	private CategoriesDAO categories;
	
	@Autowired
	private ProjectsDAO projects;
	
	@Override
	public List<Category> getAllWithProjects() {
		List<Category> result = categories.getAll();
		for (Category category : result) {
			category.getProjects().size();
		}
		return result;
	}
	
	@Override
	public Category getWithProjects(int id) {
		Category category = categories.get(id);
		category.getProjects().size();
		return category;
	}

	@Override
	public Project getProject(int id) {
		return projects.get(id);
	}

	@Override
	public List<Category> getCategories() {
		return categories.getAll();
	}

}
