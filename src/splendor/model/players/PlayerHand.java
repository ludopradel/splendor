package splendor.model.players;

import java.util.ArrayList;
import java.util.List;

import splendor.model.cards.Cards;

public class PlayerHand {

	private List<Cards> hand;
	
	public PlayerHand() {
		hand = new ArrayList<Cards>();
	}

	public void add(Cards a_card) {
		hand.add(a_card);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PlayerHand)) 
			return false;
		
		PlayerHand otherPlayerHand = (PlayerHand) obj;
		return hand.containsAll(otherPlayerHand.hand);
	}
	
}
