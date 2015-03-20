package splendor.model.players;

import splendor.model.gems.GemStock;
import splendor.model.gems.Gem;

public class Player {

	private String name;

	public Player(String name) {
		this.name = name;
	}

	public void pickGemsFrom(GemStock gemStock, Gem gemOne, Gem gemTwo, Gem gemThree) {
		gemStock.pick(gemOne);
		gemStock.pick(gemTwo);
		gemStock.pick(gemThree);
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
