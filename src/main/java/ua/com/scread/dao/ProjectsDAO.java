package ua.com.scread.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ua.com.scread.model.Project;
import ua.com.scread.model.Projects;

@Repository
public class ProjectsDAO extends AbstractDAO implements Projects{

	@Override
	public int add(Project project) {
		Session session = getSession();
        int id = (int) session.save(project);
        project.setId(id);
        return id;
	}

	@Override
	public Project get(int id) {
		Session session = getSession();
	    return (Project) session.get(Project.class, id);
	}

	@Override
	public int size() {
		return ( (Long) getSession().createQuery("SELECT count(o) FROM Project o").iterate().next() ).intValue();
	}

}
