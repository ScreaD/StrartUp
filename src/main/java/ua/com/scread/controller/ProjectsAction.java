package ua.com.scread.controller;

import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import ua.com.scread.model.Category;
import ua.com.scread.model.Project;
import ua.com.scread.service.ProjectsService;

import java.util.List;

public class ProjectsAction implements ModelDriven {

	private Project project;
	private int id;
	private List<Project> projects;
	
	@Autowired
	private ProjectsService service;

	public String findProjects() throws Exception {
		Category category = service.getWithProjects(id);
		projects = category.getProjects();
		return "success";
	}
	
	@Override
	public Object getModel() {
		return getProject();
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
