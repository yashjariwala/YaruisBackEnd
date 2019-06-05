package com.yarish.ecommercebackend.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yarish.ecommercebackend.dao.CartDAO;
import com.yarish.ecommercebackend.dao.CustomerOrderDAO;
import com.yarish.ecommercebackend.model.Cart;
import com.yarish.ecommercebackend.model.CartItem;
import com.yarish.ecommercebackend.model.CustomerOrder;

@Repository
@Transactional
public class CustomerOrderDAOImpl implements CustomerOrderDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CartDAO cartdao;

	@Autowired
	CustomerOrderDAO custorderdao;


	@Transactional
	public void addCustomerOrder(CustomerOrder customerOrder) {
		System.out.println("hello customer table ");
		Session session = sessionFactory.getCurrentSession();
		System.out.println("cust1");
		session.saveOrUpdate(customerOrder);
		System.out.println("cust2");

	}

	@Transactional
	public int getCustomerOrderGrandTotal(int cartId) {
		int grandTotal = 0;
		System.out.println("cust71 :" + cartdao.getCartByCartId(cartId));
		Cart cart = cartdao.getCartByCartId(cartId);
		List<CartItem> cartItems = cart.getCartItems();
		System.out.println("cust81");
		for (CartItem item : cartItems) {
			grandTotal += item.getTotalprice();
		}
		System.out.println("cust91");
		return grandTotal;
	}

	// @Override
	// public void delete(CustomerOrder custorderid) {
	// sessionFactory.getCurrentSession().delete(custorderid);
	//
	// }

	// @Override
	// public List<CustomerOrder> get(int customerOrderId) {
	// Session session = this.sessionFactory.getCurrentSession();
	// Query query = session.createQuery("from CustomerOrder where userid=?");
	// query.setLong(0, customerOrderId);
	// List<CustomerOrder> custorder = (List<CustomerOrder>) query.uniqueResult();
	// return custorder;
	// }

	@Transactional
	public void delete(List<CustomerOrder> customerOrder) {
		for(CustomerOrder customerorders : customerOrder ) {
			sessionFactory.getCurrentSession().delete(customerorders);	
		}
		
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public List<CustomerOrder> list(int useriddelete) {
		Session session = sessionFactory.getCurrentSession();
		Query<CustomerOrder> query = session.createQuery("from CustomerOrder where userid =?");
		query.setLong(0, useriddelete);
		List<CustomerOrder> customerorder = (List<CustomerOrder>) query.list();
		System.out.println(customerorder);
		return query.list();
	}

}
