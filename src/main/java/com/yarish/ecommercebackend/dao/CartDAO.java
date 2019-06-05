package com.yarish.ecommercebackend.dao;

import java.io.IOException;

import com.yarish.ecommercebackend.model.Cart;


public interface CartDAO {
Cart getCartByCartId(int cartId);
Cart validate(int cartId) throws IOException;
void update(Cart cart);
public void delete(int id);

}