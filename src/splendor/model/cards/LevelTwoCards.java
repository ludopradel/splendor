package splendor.model.cards;


public class LevelTwoCards extends Cards {

	private VisibleLevelTwoCards visibleCards;
	
	public LevelTwoCards() {
		visibleCards = new VisibleLevelTwoCards();
	}

	public VisibleLevelTwoCards visibleCards() {
		return this.visibleCards;
	}

}
