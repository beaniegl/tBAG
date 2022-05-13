
//The 'final boss' inherits from the Enemy class
public class FinalBoss extends Enemy {
	public FinalBoss(String name, String description, double attack, double health) {
		super("The Final Boss...",
				"This entity inhabits the void. To escape the loop, you must defeat this enemy. Strength radiates from this entity.",
				20, 20);
		// TODO Auto-generated constructor stub
	}

	// An example of Polymorphism to display a different enemy death output to a
	// normal enemy like the skeleton
	@Override
	public String noEnHealth() {
		return "The entity looks confused as his life force dwindles. He has never been defeated, and as the first you have been granted escape.";
	}
}
