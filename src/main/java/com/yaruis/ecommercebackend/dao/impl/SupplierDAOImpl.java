package com.yaruis.ecommercebackend.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yaruis.ecommercebackend.dao.SupplierDAO;
import com.yaruis.ecommercebackend.model.Supplier;
@SuppressWarnings("deprecation")
@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void save(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);

	}

	@Transactional
	public void update(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);

	}

	@Transactional
	public void delete(int id) {
		Supplier supplier = new Supplier();
		supplier.setSupplierid(id);
		sessionFactory.getCurrentSession().delete(supplier);
	}

	@Transactional
	public Supplier get(int id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);

	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public List<Supplier> listSupplier() {
		Session session = sessionFactory.getCurrentSession();
		//Session session=sessionFactory.openSession();
		System.out.println("HEllo1");
		Query query = session.createQuery("from Supplier");
		System.out.println("HEllo2");
		List<Supplier> supplier = query.list();
		//List<Supplier> supplierList=session.createQuery("from Supplier").list();
		//System.out.println("HEllo3"+ supplierList.isEmpty());
		//session.close();
		return supplier;

	}



}
