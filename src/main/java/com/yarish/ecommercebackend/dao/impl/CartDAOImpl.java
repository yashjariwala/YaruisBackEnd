package com.yarish.ecommercebackend.dao.impl;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yarish.ecommercebackend.dao.CartDAO;
import com.yarish.ecommercebackend.dao.CustomerOrderDAO;
import com.yarish.ecommercebackend.model.Cart;
import com.yarish.ecommercebackend.model.Supplier;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CustomerOrderDAO customerorederdao;

	@Autowired
	private CartDAO cartdao;

	public CartDAO getCartdao() {
		return cartdao;
	}

	public void setCartdao(CartDAO cartdao) {
		this.cartdao = cartdao;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Cart getCartByCartId(int cartId) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart) session.get(Cart.class, cartId);
		session.close();
		return cart;
	}

	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartByCartId(cartId);
		if (cart == null || cart.getCartItems().size() == 0) {
			throw new IOException(cartId + "");
		}
		update(cart);
		return cart;
	}

	public void update(Cart cart) {
		int cartId = cart.getCartId();
		int grandTotal = customerorederdao.getCustomerOrderGrandTotal(cartId);
		cart.setTotalprice(grandTotal);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}

	@Transactional
	public void delete(int id) {
		Cart cart = new Cart();
		cart.setCartId(id);
		sessionFactory.getCurrentSession().delete(cart);
		
	}

}
