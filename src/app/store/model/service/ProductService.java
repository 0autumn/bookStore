package app.store.model.service;

import java.util.List;

import app.store.model.entity.Product;

public interface ProductService {

	
	public Product getBook(long id);
	

	public List<Product> getBooksByCategoryId(long id,Integer page,Integer a_page_num);
	

	public List<Product> getAllBooks();
	

	public List<Product> searchBookFor(String keyword,Integer page,Integer a_page_num);
	
}
