package com.yaruis.ecommercebackend.dao;

import java.util.List;

import com.yaruis.ecommercebackend.model.Category;
import com.yaruis.ecommercebackend.model.Product;
import com.yaruis.ecommercebackend.model.Supplier;


public interface ProductDAO {
	public void save(Product product);

	public void update(Product product);

	public void delete(int id);

	public Product get(int productid);

	public List<Product> list();
	
//	public List<Product> listsimillarproducts();
	
	public List<Category>listcatname();
	
	public List<Supplier>listsupname();

}
