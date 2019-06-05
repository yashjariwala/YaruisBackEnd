package com.yarish.ecommercebackend.dao;

import java.util.List;

import com.yarish.ecommercebackend.model.Cart;
import com.yarish.ecommercebackend.model.CartItem;

public interface CartItemDAO {

	void addCartItem(CartItem cartItem);
	void removeCartItem(int cartitemid);
	void removeAllCartItems(Cart cart);
	public List<CartItem>list(int cartid);
	
}