package app.store.model.service;

import java.util.List;

import app.store.model.entity.Category;

public class CategoryServiceImpl extends ServiceSupport<Category> implements
		CategoryService {

	@Override
	public List<Category> getAllCategories() {
		return this.getDao().findAll();
	}

}
