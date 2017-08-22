package com.yaruis.ecommercebackend.dao;

import java.util.List;

import com.yaruis.ecommercebackend.model.ShippingAddress;

public interface ShippingAddressDAO {
	
	public void update (ShippingAddress shippingaddress);
	
	public ShippingAddress get(int shippingid);
	
	public List<ShippingAddress> list();

}
