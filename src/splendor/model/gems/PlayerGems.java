package splendor.model.gems;

import java.util.ArrayList;
import java.util.List;

public class PlayerGems {

	List<Gem> playerStock = new ArrayList<Gem>();
	
	public boolean isEmpty() {
		return playerStock.isEmpty();
	}

	public void add(Gem gem) {
		playerStock.add(gem);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PlayerGems))
			return false;
		
		PlayerGems otherPlayerGems = (PlayerGems) obj;
		return playerStock.containsAll(otherPlayerGems.playerStock);
	}
	
}
