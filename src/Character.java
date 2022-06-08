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

	public static void addItem(Item item) {
		inventory.add(item);
		System.out.println("You added a " + item.getName() + " to your inventory!");
	}

	public static void inventory() {
		System.out.println("In your inventory you currently have: ");
		for (Item invItems : inventory) {
			System.out.println(invItems.getName());
		}
	}
}
