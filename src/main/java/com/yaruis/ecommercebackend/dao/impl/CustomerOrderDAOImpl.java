package com.yaruis.ecommercebackend.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yaruis.ecommercebackend.dao.CartDAO;
import com.yaruis.ecommercebackend.dao.CustomerOrderDAO;
import com.yaruis.ecommercebackend.model.Cart;
import com.yaruis.ecommercebackend.model.CartItem;
import com.yaruis.ecommercebackend.model.CustomerOrder;

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

	@Override
	@Transactional
	public int getCustomerOrderGrandTotal(int cartId) {
		int grandTotal = 0;
		System.out.println("cust71 :" +cartdao.getCartByCartId(cartId));
		Cart cart = cartdao.getCartByCartId(cartId);
		List<CartItem> cartItems= cart.getCartItems();
		System.out.println("cust81");
		for (CartItem item : cartItems) {
			grandTotal += item.getTotalprice();
		}
		System.out.println("cust91");
		return grandTotal;
	}

}
