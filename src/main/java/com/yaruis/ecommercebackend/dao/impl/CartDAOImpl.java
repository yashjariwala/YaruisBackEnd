package com.yaruis.ecommercebackend.dao.impl;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yaruis.ecommercebackend.dao.CartDAO;
import com.yaruis.ecommercebackend.dao.CustomerOrderDAO;
import com.yaruis.ecommercebackend.model.Cart;

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

	@Override
	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartByCartId(cartId);
		System.out.println("emptycart1");
		if (cart == null || cart.getCartItems().size() == 0) {
			throw new IOException(cartId + "");
		}
		System.out.println("emptycart2");
		update(cart);
		return cart;
	}

	@Override
	public void update(Cart cart) {
		System.out.println("cart1");
		int cartId = cart.getCartId();
		System.out.println("carttot1");
		int grandTotal = customerorederdao.getCustomerOrderGrandTotal(cartId);
		cart.setTotalprice(grandTotal);

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}

}
