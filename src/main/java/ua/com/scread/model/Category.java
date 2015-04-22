package ua.com.scread.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="categories")
public class Category {
	
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="categories_id_seq")
    @SequenceGenerator(name="categories_id_seq", sequenceName="categories_id_seq", allocationSize=1)
	private int id;
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projects;
    
    public List<Project> getProjects() {
    	return projects;
    }

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Category(){	
	}
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category(int id) {
		this.id = id;
	}
	
	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category name= " + name + ", id= " + id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
