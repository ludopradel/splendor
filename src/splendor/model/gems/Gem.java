package splendor.model.gems;

public class Gem {

	public static final Gem RED = new Gem(Gems.RED);
	public static final Gem GREEN = new Gem(Gems.GREEN);
	public static final Gem BLUE = new Gem(Gems.BLUE);
	Gems color;

	public Gem(Gems gems) {
		color = gems;
	}

}
