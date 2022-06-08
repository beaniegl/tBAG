
public class Item {
	private String name;
	private String description;

	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String setName(String newName) {
		this.name = newName;
		return this.name;
	}

	public String getName() {
		return this.name;
	}

	public String setDescription(String newDescription) {
		this.description = newDescription;
		return this.description;
	}

	public String getDescription() {
		return this.description;
	}

	public String examine() {
		return getDescription();
	}

}
