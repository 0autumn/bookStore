package app.store.model.entity;

public class Category extends Entity {

	private String name;
	private String description;
	private int isDel;

	public Category() {
		super(0);
	}

	public Category(String name, String description) {
		this();
		this.setName(name);
		this.setDescription(description);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
