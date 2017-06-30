package com.yaruis.ecommercebackend.dao;

import com.yaruis.ecommercebackend.model.Cart;
import com.yaruis.ecommercebackend.model.CartItem;

public interface CartItemDAO {

	void addCartItem(CartItem cartItem);
	void removeCartItem(int cartitemid);
	void removeAllCartItems(Cart cart);
}