package app.store.action;

import java.util.List;

import app.store.model.entity.Category;
import app.store.model.service.CategoryService;

public class CategoryAction extends
		GenericActionSupport<Category, CategoryService> {

	private static final long serialVersionUID = 1L;
	
	public List<Category> getCategories(){
		return this.getService().getAllCategories();
	}

}
