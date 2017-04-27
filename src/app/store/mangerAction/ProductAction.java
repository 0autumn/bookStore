package app.store.mangerAction;

import java.util.List;

import app.store.model.entity.Product;
import app.store.model.service.ProductService;

public class ProductAction extends GenericActionSupport<Product, ProductService> {

	private static final long serialVersionUID = 1L;
	
	private long categoryId;
	private String keyword;
	private Integer page;
	private Integer a_page_num;
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
			return this.getService().searchBookFor(this.getKeyword(), page,a_page_num);
		}
		if (this.getCategoryId() == 0) {
			return this.getService().getAllBooks();
		}
		return this.getService().getBooksByCategoryId(this.getCategoryId(),page,a_page_num);
	}
	
}
