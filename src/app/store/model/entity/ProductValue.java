package app.store.model.entity;

public class ProductValue extends Entity{

	public ProductValue(){
		super(0);
		
	}
	public ProductValue(long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
    SpecInfo specinfo;
    Spec  spec;
	public SpecInfo getSpecinfo() {
		return specinfo;
	}
	public void setSpecinfo(SpecInfo specinfo) {
		this.specinfo = specinfo;
	}
	public Spec getSpec() {
		return spec;
	}
	public void setSpec(Spec spec) {
		this.spec = spec;
	}
    
}
