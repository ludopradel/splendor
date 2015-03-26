package splendor;

import splendor.exceptions.ColorPickedException;
import splendor.exceptions.NotEnoughPlayerException;
import splendor.exceptions.TooMuchPlayersException;
import splendor.model.gems.GemStock;
import splendor.model.gems.Gem;
import splendor.model.players.Player;

public class Splendor {
	public static void main(String[] args) {
		Game game;
		try {
			game = new Game("Pierre", "Paul");
			GemStock gemStock = game.gems();
			printGemStock(gemStock);
			
			Player pierre = game.next();
			pierre.pickThreeDifferentGems(gemStock, Gem.BLUE, Gem.BLACK, Gem.RED);
			printGemStock(pierre.gemStock());

			Player paul = game.next();
			paul.pickThreeDifferentGems(gemStock, Gem.BLUE, Gem.BLACK, Gem.RED);
			printGemStock(paul.gemStock());

			pierre.pickThreeDifferentGems(gemStock, Gem.BLUE, Gem.BLACK, Gem.GREEN);
			printGemStock(pierre.gemStock());

			printGemStock(gemStock);
			
		} catch (TooMuchPlayersException e) {
			System.out.println("Trop de joueurs dans la partie");
		} catch (NotEnoughPlayerException e) {
			System.out.println("Pas assez de joueurs dans la partie");
		} catch (ColorPickedException e) {
			System.out.println("Choix de gemmes impossible");
		}
	}

	protected static void printGemStock(GemStock gemStock) {
		System.out.println("gems stock : " + gemStock.count());
		System.out.println("Blue   : " + gemStock.numberOf(Gem.BLUE));
		System.out.println("Red    : " + gemStock.numberOf(Gem.RED));
		System.out.println("Green  : " + gemStock.numberOf(Gem.GREEN));
		System.out.println("Black  : " + gemStock.numberOf(Gem.BLACK));
		System.out.println("White  : " + gemStock.numberOf(Gem.WHITE));
		System.out.println("Gold   : " + gemStock.numberOf(Gem.GOLD));
	}
}
