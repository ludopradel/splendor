package splendor.model.gems;

import java.util.ArrayList;
import java.util.List;

public class PlayerGems extends GemStock {

	List<Gem> playerStock = new ArrayList<Gem>();
	
	public PlayerGems() {
		numberOfBlack = 0;
		numberOfBlue = 0;
		numberOfGold = 0;
		numberOfGreen = 0;
		numberOfRed = 0;
		numberOfWhite = 0;
	}
	
	public boolean isEmpty() {
		return playerStock.isEmpty();
	}

	public void add(Gem gem) {
		playerStock.add(gem);
		switch (gem) {
		case BLACK:
			numberOfBlack++;
			break;
		case BLUE:
			numberOfBlue++;
			break;
		case GOLD:
			numberOfGold++;
			break;
		case GREEN:
			numberOfGreen++;
			break;
		case RED:
			numberOfRed++;
			break;
		case WHITE:
			numberOfWhite++;
			break;

		default:
			break;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PlayerGems))
			return false;
		
		PlayerGems otherPlayerGems = (PlayerGems) obj;
		return playerStock.containsAll(otherPlayerGems.playerStock);
	}
	
}
