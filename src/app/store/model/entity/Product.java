package app.store.model.entity;

public class Product extends Entity {
    
	private String name;
	private String title;
	private float price;
	private String coverImageFile;
	private int isDel;
	private int stock;
	private Category category;
	
	public Product(){
		super(0);
	}
	public Product(String name, float price, String imageFile,int isDel,int stock){
		this();
		this.setName(name);
		this.setPrice(price);
		this.setCoverImageFile(imageFile);
		this.setIsDel(isDel);
		this.setStock(stock);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCoverImageFile() {
		return coverImageFile;
	}
	public void setCoverImageFile(String coverImageFile) {
		this.coverImageFile = coverImageFile;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
