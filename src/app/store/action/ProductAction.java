package app.store.action;

import java.util.List;

import app.store.model.entity.Product;
import app.store.model.service.ProductService;

public class ProductAction extends GenericActionSupport<Product, ProductService> {

	private static final long serialVersionUID = 1L;
	private int productId;
	private long categoryId;
	private String keyword;
    private Integer page;
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
		
	public List<Product> getBooks()
	{      
		if (this.getKeyword() != null && !this.getKeyword().isEmpty()){
			return this.getService().searchBookFor(this.getKeyword(), page,12);
		}
		if (this.getCategoryId() == 0) {
			return this.getService().getAllBooks();
		}
		return this.getService().getBooksByCategoryId(this.getCategoryId(),page,12);
	}
	
	
	
}
