package app.store.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.store.model.entity.Product;
import app.store.model.entity.ProductValue;
import app.store.model.service.ProductService;
import app.store.model.service.ProductValueServiceImpl;
import app.store.model.service.SpecServiceImpl;

public class ProductAction extends GenericActionSupport<Product, ProductService> {

	private static final long serialVersionUID = 1L;
	private int productId;
	private long categoryId;
	private String keyword;
    private Integer page;
	private SpecServiceImpl specSevice;
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public SpecServiceImpl getSpecSevice() {
		return specSevice;
	}

	public void setSpecSevice(SpecServiceImpl specSevice) {
		this.specSevice = specSevice;
	}

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
      //得到某个产品的具体数据	
	public Map<String,Object> getProductMsg(){
		Map<String,Object> map =new HashMap<>();
		map.put("poduct",this.getService().getProductMsg(productId));
		map.put("spec",this.specSevice.getSpecs(productId));
		
		return map;
		
	}
	
}
