package com.yaruis.ecommercebackend.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yaruis.ecommercebackend.dao.BillingAddressDAO;
import com.yaruis.ecommercebackend.dao.ShippingAddressDAO;
import com.yaruis.ecommercebackend.model.BillingAddress;
import com.yaruis.ecommercebackend.model.Cart;
import com.yaruis.ecommercebackend.model.ShippingAddress;

@Repository("BillingAddressDAO")
public class BillingAddressDAOImpl implements BillingAddressDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void update(BillingAddress billingaddress) {
		sessionFactory.getCurrentSession().update(billingaddress);
	}

	@Transactional
	public BillingAddress get(int billingid) {
		Session session = sessionFactory.openSession();
		System.out.println("Hello1");
		BillingAddress billingaddress = (BillingAddress) session.get(BillingAddress.class, billingid);
		System.out.println("Hello2");
		session.close();
		System.out.println("hello 3");
		return billingaddress;
	}
	
	@Transactional
	public List<BillingAddress> list() {
		String hql = "from BillingAddress";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

	@Transactional
	public void delete(int id) {
		BillingAddress billingaddress = new BillingAddress();
		billingaddress.setBillingid(id);
		sessionFactory.getCurrentSession().delete(billingaddress);
		
	}

}
