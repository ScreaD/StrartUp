package ua.com.scread.controller;

import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import ua.com.scread.model.Project;
import ua.com.scread.service.ProjectsService;

public class ProjectAction implements ModelDriven {
	
	private Project project;
	private int id;
	
	@Autowired
	private ProjectsService service;

	public String current(){
		project = service.getProject(id);
		return "success";
	}
	
	@Override
	public Object getModel() {
		return getProject();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
