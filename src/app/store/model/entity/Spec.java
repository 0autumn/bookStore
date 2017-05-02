package app.store.model.entity;

import java.util.Set;

public class Spec extends Entity{
 
  private String  spec_name;
  private Product product;
  private Set<SpecInfo> specInfos;
  
   public Spec(){
	   super(0);
   }
  public Spec(long id) {
		super(id);
		
	}
  
  public Spec(long id,String  spec_name){
	  super(id);
	  this.setSpec_name(spec_name);
  }
  
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public String getSpec_name() {
	return spec_name;
}
public void setSpec_name(String spec_name) {
	this.spec_name = spec_name;
}
public Set<SpecInfo> getSpecInfos() {
	return specInfos;
}
public void setSpecInfos(Set<SpecInfo> specInfos) {
	this.specInfos = specInfos;
}
  
}
