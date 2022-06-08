
public class Enemy {
	private String name;
	private String description;
	private double attack;
	private double health;

	public Enemy(String name, String description, double attack, double health) {
		this.name = name;
		this.description = description;
		this.attack = attack;
		this.health = health;
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

	public double setHealth(double newHealth) {
		this.health = newHealth;
		return this.health;
	}

	public double getHealth() {
		return this.health;
	}

	public double setAttack(double newAttack) {
		this.attack = newAttack;
		return this.attack;
	}

	public double getAttack() {
		return this.attack;
	}

	public String spawn() {
		return getDescription();
	}

	public String noEnHealth() {
		return "You defeated the enemy!";
	}
}