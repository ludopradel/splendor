package splendor.model.players;

import splendor.exceptions.ColorPickedException;
import splendor.model.cards.Cards;
import splendor.model.gems.Gem;
import splendor.model.gems.GemStock;
import splendor.model.gems.PlayerGems;

public class Player {

	private String name;
	private PlayerGems personalStock;
	private PlayerHand hand;

	public Player(String name) {
		this.name = name;
		personalStock = new PlayerGems();
		hand = new PlayerHand();
	}

	public void pickThreeDifferentGems(GemStock gemBank, Gem gemOne, Gem gemTwo, Gem gemThree) throws ColorPickedException {
		if (twoGemsHaveSameColor(gemOne, gemTwo, gemThree)) {
			throw new ColorPickedException();
		}
		
		gemBank.pick(gemOne);
		gemBank.pick(gemTwo);
		gemBank.pick(gemThree);
		
		personalStock.add(gemOne);
		personalStock.add(gemTwo);
		personalStock.add(gemThree);
	}

	protected boolean twoGemsHaveSameColor(Gem gemOne, Gem gemTwo, Gem gemThree) {
		return gemOne.equals(gemTwo) || gemOne.equals(gemThree) || gemTwo.equals(gemThree);
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
	
	@Override
	public String toString() {
		return "Player : " + name;
	}

	public void pickTwoIdenticalGems(GemStock gemBank, Gem gem) {
		gemBank.pick(gem);
		gemBank.pick(gem);
		
		personalStock.add(gem);
		personalStock.add(gem);
	}

	public void pickCard(Cards a_card) {
		hand.add(a_card);
	}

	public PlayerHand cardsInHand() {
		return hand;
	}
}
