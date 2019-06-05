package com.yarish.ecommercebackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yarish.ecommercebackend.dao.CategoryDAO;
import com.yarish.ecommercebackend.model.Category;

@Repository("CategoryDAO")

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void save(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

	@Transactional
	public void update(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}

	@Transactional
	public void delete(int id) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.setCategoryid(id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);

	}

	@Transactional
	public Category get(int id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Transactional
	public List<Category> list() {
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
