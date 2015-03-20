package splendor.model.gems;

public class GemStock {

	private int numberOfRed;
	private int numberOfBlue;
	private int numberOfBlack;
	private int numberOfGreen;
	private int numberOfWhite;
	private int numberOfGold;
	final static int INITIAL_NUMBER_OF_GEMS = 7;
	final static int INITIAL_NUMBER_OF_BONUS_GEMS = 5;
	
	private GemStock() {
		numberOfRed = INITIAL_NUMBER_OF_GEMS;
		numberOfBlue = INITIAL_NUMBER_OF_GEMS;
		numberOfBlack = INITIAL_NUMBER_OF_GEMS;
		numberOfGreen = INITIAL_NUMBER_OF_GEMS;
		numberOfWhite = INITIAL_NUMBER_OF_GEMS;
		numberOfGold = INITIAL_NUMBER_OF_BONUS_GEMS;
	}
	
	public static GemStock initialise() {
		return new GemStock();
		
	}

	public Boolean all() {
		return Boolean.TRUE;
	}

	public Integer count() {
		return 40;
	}

	public Integer numberOf(Gem gem) {
		switch (gem) {
		case RED:
			return numberOfRed;
		case BLUE:
			return numberOfBlue;
		case BLACK:
			return numberOfBlack;
		case GREEN:
			return numberOfGreen;
		case WHITE:
			return numberOfWhite;
		case GOLD:
			return numberOfGold;
		default:
			return 0;
		}
	}

	public void pick(Gem gems) {
		switch (gems) {
		case RED:
			numberOfRed--;
			break;
		case BLUE:
			numberOfBlue--;
			break;
		case BLACK:
			numberOfBlack--;
			break;
		case GREEN:
			numberOfGreen--;
			break;
		case WHITE:
			numberOfWhite--;
			break;
		case GOLD:
			numberOfGold--;
			break;
		}
	}
	
}
