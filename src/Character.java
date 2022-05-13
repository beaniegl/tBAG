import java.util.ArrayList;

public class Character {
	private String name;
	protected double health;
	private int attack;
	private static Room location;

	static ArrayList<Item> inventory = new ArrayList<Item>();

	public Character(String name, double health, int attack, Room rRoom) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.location = rRoom;
	}

	public String setName(String newName) {
		this.name = newName;
		return this.name;
	}

	public String getName() {
		return this.name;
	}

	public double setHealth(double newHealth) {
		this.health = newHealth;
		return this.health;
	}

	public double getHealth() {
		return this.health;
	}

	public int setAttack(int newAttack) {
		this.attack = newAttack;
		return this.attack;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setRoom(Room rRoom) {
		this.location = rRoom;
	}

	public static Room getRoom() {
		return location;
	}

	public void hpPotion() {
		double potionHealth = health + 20;
		setHealth(potionHealth);
	}

	public static void addItem(Item item) {
		inventory.add(item);
	}

	public void dropItem(Item item) {
		inventory.remove(item);
	}

	public static void inventory() {
		for (Item invItems : inventory) {
			System.out.println(invItems.getName());
		}
	}
}
