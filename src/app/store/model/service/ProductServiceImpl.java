package app.store.model.service;

import java.util.ArrayList;
import java.util.List;

import app.store.model.entity.Product;

public class ProductServiceImpl extends ServiceSupport<Product> implements
		ProductService {

	@Override
	public Product getBook(long id) {
		return this.getDao().get(id);
	}

	@Override
	public List<Product> getBooksByCategoryId(long id) {
		return this.getDao().findBy("category.id", id);
	}

	@Override
	public List<Product> getAllBooks() {
		return this.getDao().findAll();
	}

	@Override
	public List<Product> searchBookFor(String keyword) {
		List<Product> resultBooks = new ArrayList<Product>();
		List<Product> allBooks = this.getAllBooks();
		for (Product book : allBooks){
			if (book.getName().contains(keyword) || 
				book.getCategory().getName().contains(keyword) || 
				book.getCategory().getDescription().contains(keyword)) {
				resultBooks.add(book);
			}
		}
		return resultBooks;
	}

}
