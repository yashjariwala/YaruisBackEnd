package com.yarish.ecommercebackend.dao;

import java.util.List;

import com.yarish.ecommercebackend.model.ShippingAddress;

public interface ShippingAddressDAO {
	
	public void update (ShippingAddress shippingaddress);
	
	public ShippingAddress get(int shippingid);
	
	public List<ShippingAddress> list();
	
	public void delete(int id);

}
