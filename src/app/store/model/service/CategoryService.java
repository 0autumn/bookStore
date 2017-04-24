package app.store.model.service;

import java.util.List;

import app.store.model.entity.Category;

public interface CategoryService {

	/**
	 * �������е�ͼ�����
	 * @return ͼ�������б�
	 */
	List<Category> getAllCategories();
}
