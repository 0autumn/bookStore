package app.store.model.entity;

public class SpecInfo extends Entity {
	private String spec_value;
    private Spec spec;
    
    public SpecInfo(){
    	super(0);
    }
    public SpecInfo(long id,String spec_value){
    	super(id);
    	this.setSpec_value(spec_value);
    }
	public Spec getSpec() {
		return spec;
	}

	public void setSpec(Spec spec) {
		this.spec = spec;
	}



	public String getSpec_value() {
		return spec_value;
	}

	public void setSpec_value(String spec_value) {
		this.spec_value = spec_value;
	}

	public SpecInfo(long id) {
		super(id);
		
	}

}
