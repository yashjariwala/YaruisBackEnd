package com.yaruis.ecommercebackend.dao;

import java.io.IOException;

import com.yaruis.ecommercebackend.model.Cart;


public interface CartDAO {
Cart getCartByCartId(int cartId);
Cart validate(int cartId) throws IOException;
void update(Cart cart);

}