import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	private static Boolean gameOver = false;

	private static ArrayList<Room> map = new ArrayList<Room>();

	private static Character warrior = new Character("", 0, 0, null);

	private static Skeleton skeleton = new Skeleton("", "", 10, 10);

	private static FinalBoss fb = new FinalBoss("", "", 20, 25);

	public static void gameSetup() {

		Item sword = new Item("Sword", "This is a long sword which could improve your attack.");
		Item potion = new Item("Potion", "This warm potion gives you +20 health.");
		Item axe = new Item("Axe", "This heavy axe looks like it would improve your attack massively.");
		Item poison = new Item("Yummy Potion",
				"This cold to the touch vial instantly inflicts damage. It was actually poison!");
		Item nullItem = new Item("There is nothing here!", "");

		Room r1 = new Room("Origin Room.",
				"This room is cold and foggy. There is an exit to the north, but it would be good to explore. There may be an item in here, but also maybe an enemy.",
				1, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, sword);
		Room r2 = new Room("Cave",
				"You have found yourself in a labyrinth of rocky pillars. There seems to be an exit to the east. This room seems safe, and there may be items lying around.",
				Direction.NOEXIT, 0, 2, Direction.NOEXIT, potion);
		Room r3 = new Room("Meadows",
				"After your eyes have adjusted to the bright sunshine, you find yourself in a field, surrounded by tall hay and grass. There seems to be an exit to the south.",
				Direction.NOEXIT, 3, Direction.NOEXIT, 1, poison);
		Room r4 = new Room("Dungeon",
				"After exiting the field, you stumble down into a dungeon. There seems to be lots of threatening enemies here, and you can just about see an exit to the east.",
				2, Direction.NOEXIT, 4, Direction.NOEXIT, axe);
		Room r5 = new Room("Void",
				"You suddenly lose gravity as you float in the dark space, void of anything. There is a floating entity in front of you. He awakens and comes towards you.",
				Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 3, nullItem);

		map.add(r1);
		map.add(r2);
		map.add(r3);
		map.add(r4);
		map.add(r5);

		warrior.setRoom(map.get(0));
	}

	private static void getCurrentRDesc() {
		String currentRoom = Character.getRoom().getDescription();
		System.out.println(currentRoom);
	}

	private static void placeChar(Character war, Room r) {
		war.setRoom(r);
	}

	private static int findExit(Character war, Direction dir) {
		Room goTo = Character.getRoom();
		int exit;

		switch (dir) {
		case NORTH:
			exit = goTo.getN();
			break;
		case SOUTH:
			exit = goTo.getS();
			break;
		case EAST:
			exit = goTo.getE();
			break;
		case WEST:
			exit = goTo.getW();
			break;
		default:
			exit = Direction.NOEXIT;
			break;
		}
		if (exit != Direction.NOEXIT) {
			placeChar(war, map.get(exit));
		}
		return exit;
	}

	private static void moveWarriorTo(Direction dir) {
		if (findExit(warrior, dir) == Direction.NOEXIT) {
			System.out.println("No Exit!");
		} else {
			System.out.println(Character.getRoom().getDescription());
		}
	}

	private static void goN() {
		moveWarriorTo(Direction.NORTH);
	}

	private static void goS() {
		moveWarriorTo(Direction.SOUTH);
	}

	private static void goW() {
		moveWarriorTo(Direction.WEST);
	}

	private static void goE() {
		moveWarriorTo(Direction.EAST);
	}

	private static void fight() {
		double i = skeleton.getHealth();
		Scanner myObj = new Scanner(System.in);
		if (Character.getRoom().getName().equals("Void")) {
			System.out.println(fb.spawn());
			while (fb.getHealth() > 0 || warrior.getHealth() > 0) {
				System.out.println("Would you like to attack?");
				String command = myObj.nextLine().toLowerCase();
				if (command.equals("attack")) {
					System.out.println("You attacked the final boss!");
					double tempHealth = fb.getHealth();
					tempHealth = tempHealth - warrior.getAttack();
					fb.setHealth(tempHealth);
					System.out.println("The final boss now has: " + fb.getHealth() + " health.");
					if (fb.getHealth() > 0) {
						double tempHealth2 = warrior.getHealth();
						tempHealth2 = tempHealth2 - (fb.getAttack());
						warrior.setHealth(tempHealth2);
						System.out.println("The final boss attacked you back!");
						System.out.println("Your new health is: " + warrior.getHealth());
					} else if (fb.getHealth() <= 0) {
						System.out.println(fb.noEnHealth());
						break;
					}
				}
			}
			gameOver();
		} else {
			System.out.println(skeleton.spawn());
			System.out.println("The enemy has: " + skeleton.getHealth() + " health.");
			while (skeleton.getHealth() > 0 || warrior.getHealth() > 0) {
				System.out.println("Would you like to attack or flee?");
				String command = myObj.nextLine().toLowerCase();

				if (command.equals("flee")) {
					double tempHealth = warrior.getHealth();
					tempHealth = tempHealth - (skeleton.getAttack() * 2);
					warrior.setHealth(tempHealth);
					System.out.println("Upon fleeing you took double damage from the enemy!");
					System.out.println("Your new health is: " + warrior.getHealth());
					break;
				} else if (command.equals("attack")) {
					System.out.println("You attacked the enemy! ");
					double tempHealth = skeleton.getHealth();
					tempHealth = tempHealth - warrior.getAttack();
					skeleton.setHealth(tempHealth);
					if (skeleton.getHealth() > 0) {
						double tempHealth2 = warrior.getHealth();
						tempHealth2 = tempHealth2 - (skeleton.getAttack());
						warrior.setHealth(tempHealth2);
						System.out.println("The skeleton attacked you back!");
						System.out.println("Your new health is: " + warrior.getHealth());
					} else {
						System.out.println(skeleton.noEnHealth());
						System.out.println("Your health is: " + warrior.getHealth());
						break;
					}
				}
			}
		}
		i = i-2;
		skeleton.setHealth(i);
	}

	public static void forf() {
		int max = 10;
		Random fiorfli = new Random();
		int value = fiorfli.nextInt(max);
		if (Character.getRoom().getName().equals("Void")) {
			System.out.println(
					"You attempted to move to search for objects which could help, but this entity cast a spell which froze you on the spot. It looks like you'll need to fight in order to survive.");
			fight();
		} else if (value >= 6) {
			System.out.println("You took a wrong turn and found an enemy!");
			fight();
		} else {
			System.out.println("You avoided the enemy and searched for items.");
			Room temp = Character.getRoom();
			System.out.println("After a thorough search you found: " + temp.getrItem().getName());
		}
	}

	public static void applyItem(Item aItem) {
		if (aItem.getName().equals("Sword")) {
			warrior.setAttack(warrior.getAttack() + 1);
			System.out.println("This item gave you +1 attack! Your new attack is: " + warrior.getAttack());
		} else if (aItem.getName().equals("Axe")) {
			warrior.setAttack(warrior.getAttack() + 3);
			System.out.println("This item gave you +3 attack! Your new attack is: " + warrior.getAttack());
		} else if (aItem.getName().equals("Potion")) {
			warrior.setHealth(warrior.getHealth() + 20);
			System.out.println("Your new health is: " + warrior.getHealth());
		} else if (aItem.getName().equals("Yummy Potion")) {
			warrior.setHealth(warrior.getHealth() - 50);
			System.out.println(
					Character.getRoom().getrItem().getDescription() + " Your new health is: " + warrior.getHealth());
		} else {
			System.out.println("This item has no effect.");
		}
	}

	public static void gameLoop() {
		getCurrentRDesc();
		while (warrior.getHealth() > 0 && gameOver == false) {
			Scanner myObj = new Scanner(System.in);
			System.out.println("Enter a command: ");
			String command = myObj.nextLine().toLowerCase();

			if (command.equals("explore")) {
				forf();
			}// else if (command.equals("i")) {
				//Character.inventory();
			//}
			else if (command.equals("g")) {
				System.out.println("Get");
				Item temp = Character.getRoom().getrItem();
				Character.addItem(temp);
				applyItem(temp);
				Room.nullifyItem(temp);
			} else if (command.equals("ex")) {
				System.out.println("Examine");
				System.out.println(Character.getRoom().getrItem().getDescription());
			} else if (command.equals("n")) {
				goN();
			} else if (command.equals("e")) {
				goE();
			} else if (command.equals("s")) {
				goS();
			} else if (command.equals("w")) {
				goW();
			} else if (command.equals("cmd")) {
				cmdMenu();
			} else if (command.equals("stats")) {
				stats();
			} else if (command.equals("room")) {
				getCurrentRDesc();
			} else if (command.equals("end")) {
				gameOver();
			} else {
				System.out.println("Please try again.");
			}
		}
	}

	public void voidnoHealth() {
		System.out.println("Oh no! You have died.");
		gameOver = true;
	}

	public static void cmdMenu() {
		System.out.println("'explore' = Explore");
		System.out.println("'n', 's', 'w', and 'e' = Direction");
		//System.out.println("'i' = Inventory");
		System.out.println("'g' = Pickup");
		System.out.println("'ex' = Examine");
		System.out.println("'stats' = Stats");
		System.out.println("'cmd' = Help Menu");
		System.out.println("'end' = End Game");
		System.out.println("Press Enter to continue.");
	}

	public static void stats() {
		System.out.println("Here are your stats: ");
		System.out.println("Name: " + warrior.getName());
		System.out.println("Health: " + warrior.getHealth());
		System.out.println("Attack: " + warrior.getAttack());
	}

	public static void setupCharacter() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("What is your name, warrior:");
		String wName = myObj.nextLine();
		warrior.setName(wName);
		System.out.println("What difficulty would you like to play on, " + warrior.getName()
				+ "? Easy (1), Medium (2) or Hard (3):");
		int difficulty = myObj.nextInt();

		if (difficulty == 3) {
			warrior.setHealth(75);
			warrior.setAttack(3);
		} else if (difficulty == 1) {
			warrior.setHealth(125);
			warrior.setAttack(8);
		} else if (difficulty == 2) {
			warrior.setHealth(100);
			warrior.setAttack(5);
		} else {
			System.out.println("Sorry, I don't understand, please choose one of the difficulties.");
		}
	}

	public static void gameOver() {
		System.out.println("You have completed the game! Well done.");
		gameOver = true;
	}

	public static void run() {
		gameSetup();

		Scanner sc = new Scanner(System.in);
		System.out.println("Hello! Welcome to tBAG. Let's run through the basic commands. Press Enter.");
		sc.nextLine();

		cmdMenu();

		sc.nextLine();
		System.out.println("Now that you're familiar with the commands, let's setup your character.");
		sc.nextLine();
		setupCharacter();

		stats();

		sc.nextLine();
		System.out.println("Your adventure begins here, " + warrior.getName() + "...");

		gameLoop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (gameOver == false) {
			run();
		}
	}
}
