package com.yaruis.ecommercebackend.dao;

import java.util.List;

import com.yaruis.ecommercebackend.model.CustomerOrder;

public interface CustomerOrderDAO {

	void addCustomerOrder(CustomerOrder customerOrder);

	int getCustomerOrderGrandTotal(int cartId);
	
	public void delete(List<CustomerOrder> customerOrder);
	
	public List<CustomerOrder>list(int useriddelete);
}
