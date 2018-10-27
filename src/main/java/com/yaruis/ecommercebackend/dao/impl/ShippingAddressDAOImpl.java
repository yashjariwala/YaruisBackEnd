package com.yaruis.ecommercebackend.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yaruis.ecommercebackend.dao.ShippingAddressDAO;
import com.yaruis.ecommercebackend.model.Cart;
import com.yaruis.ecommercebackend.model.ShippingAddress;
import com.yaruis.ecommercebackend.model.Supplier;

@Repository("ShippingAddressDAO")
public class ShippingAddressDAOImpl implements ShippingAddressDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void update(ShippingAddress shippingaddress) {
		sessionFactory.getCurrentSession().update(shippingaddress);
	}

	@Transactional
	public ShippingAddress get(int shippingid) {
		Session session = sessionFactory.openSession();
		System.out.println("Hello1");
		ShippingAddress shippingaddress = (ShippingAddress) session.get(ShippingAddress.class, shippingid);
		System.out.println("Hello2");
		session.close();
		System.out.println("hello 3");
		return shippingaddress;
	}

	@Transactional
	public List<ShippingAddress> list() {
		String hql = "from ShippingAddress";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

	@Transactional
	public void delete(int id) {
		ShippingAddress shippingaddress = new ShippingAddress();
		shippingaddress.setShippingid(id);
		sessionFactory.getCurrentSession().delete(shippingaddress);
	}

}
