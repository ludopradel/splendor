package splendor;

import splendor.model.cards.Cards;
import splendor.model.cards.LevelOneCards;
import splendor.model.cards.LevelThreeCards;
import splendor.model.cards.LevelTwoCards;
import splendor.model.gems.GemStock;
import splendor.model.lords.Lords;
import splendor.model.players.Players;

public class Game {

	private Players players;
	private Cards cards;
	private Lords lords;
	private GemStock gems;
	
	public Game() {
		cards = new Cards();
		players = new Players();
		lords = new Lords();
		gems = GemStock.initialise();
	}

	public Players players() {
		return players;
	}

	public LevelOneCards levelOneCards() {
		return cards.levelOneCards();
	}

	public LevelTwoCards levelTwoCards() {
		return cards.levelTwoCards();
	}

	public LevelThreeCards levelThreeCards() {
		return cards.levelThreeCards();
	}

	public Lords lords() {
		return lords;
	}

	public GemStock gems() {
		return gems;
	}

}