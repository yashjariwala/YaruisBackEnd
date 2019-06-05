package com.yarish.ecommercebackend.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yarish.ecommercebackend.dao.CartItemDAO;
import com.yarish.ecommercebackend.model.Cart;
import com.yarish.ecommercebackend.model.CartItem;

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
	@SuppressWarnings("deprecation")
	@Transactional
	public List<CartItem> list(int cartid) {
		Session session = sessionFactory.getCurrentSession();
		Query<CartItem> query = session.createQuery("from CartItem  where cartid =?");
		query.setLong(0, cartid);
		List<CartItem> cartitem = (List<CartItem>) query.list();
		System.out.println("The execution is "+cartitem);
		return query.list();
	}

}
