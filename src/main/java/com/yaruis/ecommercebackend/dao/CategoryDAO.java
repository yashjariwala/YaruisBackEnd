
package com.yaruis.ecommercebackend.dao;

import java.util.List;

import com.yaruis.ecommercebackend.model.Category;

public interface CategoryDAO {

	public void save(Category category);

	public void update(Category category);

	public void delete(int id);

	public Category get(int id);

	public List<Category> list();
}
