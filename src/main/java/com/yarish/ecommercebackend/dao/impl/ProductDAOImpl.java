package com.yarish.ecommercebackend.dao.impl;

import java.nio.file.Files;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yarish.ecommercebackend.dao.ProductDAO;
import com.yarish.ecommercebackend.model.Category;
import com.yarish.ecommercebackend.model.Product;
import com.yarish.ecommercebackend.model.Supplier;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void save(Product product) {

		sessionFactory.getCurrentSession().saveOrUpdate(product);

	}

	@Transactional
	public void update(Product product) {
		sessionFactory.getCurrentSession().update(product);
	}

	@Transactional
	public void delete(int id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setProductid(id);
		System.out.println(ProductToDelete);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
	}

	@Transactional
	public Product get(int productid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productid);
	}

	@Transactional
	public List<Product> list() {
		String hql = "from Product";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public List<Category> listcatname() {
		String hql = "Select categoryname from Category";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public List<Supplier> listsupname() {
		String hql = "Select suppliername from Supplier";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();
	}



}
