package splendor.model.players;

import splendor.model.gems.Gem;
import splendor.model.gems.GemStock;

public class Player {

	private String name;

	public Player(String name) {
		this.name = name;
	}

	public void pickGemsFrom(GemStock gemStock, Gem red, Gem green, Gem blue) {
		
	}

	public String name() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Player))
			return false;
		
		Player otherPlayer = (Player) obj;
		return name.equals(otherPlayer.name);
	}

}
