package ua.com.scread.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ua.com.scread.model.Categories;
import ua.com.scread.model.Category;

import java.util.List;

@Repository
public class CategoriesDAO extends AbstractDAO implements Categories {

	@Override
	public int add(Category category) {
		Session session = getSession();
		int id = (int)session.save(category);
		category.setId(id);
		return id;
	}

	@Override
	public List<Category> getAll() {
		Session session = getSession();
		Query query = session.createQuery("FROM Category");
		return (List<Category>) query.list();
	}

	@Override
	public Category get(int id) {
		Session session = getSession();
		return (Category) session.get(Category.class, id);
	}

	@Override
	public int size() {
		return ( (Long) getSession().createQuery("SELECT count(o) FROM Category o").iterate().next() ).intValue();
	}

}
