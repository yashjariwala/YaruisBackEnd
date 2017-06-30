package com.yaruis.ecommercebackend.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yaruis.ecommercebackend.dao.CartItemDAO;
import com.yaruis.ecommercebackend.model.Cart;
import com.yaruis.ecommercebackend.model.CartItem;

@Repository
@Transactional
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);

	}

	@Transactional
	public void removeCartItem(int cartitemid) {
		Session session = sessionFactory.getCurrentSession();
		CartItem cartItem = (CartItem) session.get(CartItem.class, cartitemid);
		session.delete(cartItem);

		Cart cart = cartItem.getCart();
		List<CartItem> cartItems = cart.getCartItems();
		cartItems.remove(cartItem);

	}

	@Transactional
	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			removeCartItem(cartItem.getCartitemid());
		}

	}

}
