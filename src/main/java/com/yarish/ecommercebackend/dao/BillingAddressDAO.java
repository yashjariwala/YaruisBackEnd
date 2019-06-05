package com.yarish.ecommercebackend.dao;

import java.util.List;

import com.yarish.ecommercebackend.model.BillingAddress;

public interface BillingAddressDAO {
	
	public void update (BillingAddress billingaddress);
	
	public BillingAddress get(int billingid);
	
	public List<BillingAddress> list();
	
	public void delete(int id);

}
