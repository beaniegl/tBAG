
public class Skeleton extends Enemy {

	public Skeleton(String name, String description, double attack, double health) {
		super("Skeleton",
				"An angry skeleton spawned, and starts running towards you. This short but angry skeleton exists only to inflict pain!",
				10, 7);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String noEnHealth() {
		return "The Skeleton scurries away into the darkness to replenish health, and maybe return to fight later.";
	}
}
