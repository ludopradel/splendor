package splendor.model.cards;


public class LevelOneCards extends Cards {

	private VisibleLevelOneCards visibleCards;

	public LevelOneCards() {
		visibleCards = new VisibleLevelOneCards();
	}

	public VisibleLevelOneCards visibleCards() {
		return this.visibleCards;
	}

}
