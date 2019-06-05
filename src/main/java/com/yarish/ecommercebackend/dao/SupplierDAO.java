package com.yarish.ecommercebackend.dao;

import java.util.List;

import com.yarish.ecommercebackend.model.Supplier;


public interface SupplierDAO {
	
	public void save(Supplier supplier);

	public void update(Supplier supplier);

	public void delete(int id);

	public Supplier get(int id);

	public List<Supplier> listSupplier();
}
