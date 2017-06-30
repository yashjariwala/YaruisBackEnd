package com.yaruis.ecommercebackend.dao;

import com.yaruis.ecommercebackend.model.CustomerOrder;

public interface CustomerOrderDAO {

	void addCustomerOrder(CustomerOrder customerOrder);

	int getCustomerOrderGrandTotal(int cartId);

}
