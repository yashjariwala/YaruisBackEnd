package com.yarish.ecommercebackend.dao;

import java.util.List;

import com.yarish.ecommercebackend.model.Category;
import com.yarish.ecommercebackend.model.Product;
import com.yarish.ecommercebackend.model.Supplier;


public interface ProductDAO {
	public void save(Product product);

	public void update(Product product);

	public void delete(int id);

	public Product get(int productid);

	public List<Product> list();
	
	public List<Product> listprodbycategory(String nameofcatgtobesorted);
	
//	public List<Product> listsimillarproducts();
	
	public List<Category>listcatname();
	
	public List<Supplier>listsupname();

}
