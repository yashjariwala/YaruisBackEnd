package com.yaruis.ecommercebackend.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yaruis.ecommercebackend.dao.ShippingAddressDAO;
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
		return (ShippingAddress) sessionFactory.getCurrentSession().get(ShippingAddress.class, shippingid);
	}

	@Transactional
	public List<ShippingAddress> list() {
		String hql = "from ShippingAddress";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
}
