import java.util.*;

public class Room {
	private String name;
	private String description;
	private ArrayList<Item> contents;
	private Item rItem;

	private int n, s, w, e;

	public Room(String name, String description, int nN, int sS, int eE, int wW, Item rItem) {
		this.name = name;
		this.description = description;
		this.contents = new ArrayList<>();

		this.n = nN;
		this.s = sS;
		this.e = eE;
		this.w = wW;

		this.rItem = rItem;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setrItem(Item rItem) {
		this.rItem = rItem;
	}

	public Item getrItem() {
		return this.rItem;
	}

	public void addItem(Item item) {
		contents.add(item);
	}

	public static void removeItem(Item item) {
		Room room = new Room(null, null, 0, 0, 0, 0, null);
		room.setrItem(item);
		// contents.remove(item);
	}

	public int getN() {
		return n;
	}

	public void setN(int nN) {
		this.n = nN;
	}

	public int getS() {
		return s;
	}

	public void setS(int sS) {
		this.s = sS;
	}

	public int getE() {
		return e;
	}

	public void setE(int eE) {
		this.e = eE;
	}

	public int getW() {
		return w;
	}

	public void setW(int wW) {
		this.w = wW;
	}

}
