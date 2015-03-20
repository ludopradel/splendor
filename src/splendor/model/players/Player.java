package splendor.model.players;

import splendor.model.gems.GemStock;
import splendor.model.gems.Gem;
import splendor.model.gems.PlayerGems;

public class Player {

	private String name;
	private PlayerGems personalStock;

	public Player(String name) {
		this.name = name;
		personalStock = new PlayerGems();
	}

	public void pickGemsFrom(GemStock gemBank, Gem gemOne, Gem gemTwo, Gem gemThree) {
		gemBank.pick(gemOne);
		gemBank.pick(gemTwo);
		gemBank.pick(gemThree);
		
		personalStock.add(gemOne);
		personalStock.add(gemTwo);
		personalStock.add(gemThree);
		
		
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

	public PlayerGems gemStock() {
		return personalStock;
	}

}
