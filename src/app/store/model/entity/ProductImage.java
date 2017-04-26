package app.store.model.entity;

public class ProductImage extends Entity {

 public ProductImage(long id) {
		super(id);
		
	}
private String imageName;
 private int isDel;
 private int productId;
 
public int getIsDel() {
	return isDel;
}
public void setIsDel(int isDel) {
	this.isDel = isDel;
}

public String getImageName() {
	return imageName;
}
public void setImageName(String imageName) {
	this.imageName = imageName;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}

 
}
