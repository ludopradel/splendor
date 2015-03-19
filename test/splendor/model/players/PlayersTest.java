package splendor.model.players;

import org.junit.Test;

import splendor.exceptions.NotEnoughPlayerException;
import splendor.exceptions.TooMuchPlayersException;

public class PlayersTest {
	
	@Test(expected=TooMuchPlayersException.class)
	public void game_should_not_have_more_than_four_players() throws Exception {
		new Players("Pierre", "Luc", "Paul", "Sophie", "Anne");
	}
	
	@Test(expected=NotEnoughPlayerException.class)
	public void game_should_not_have_less_than_two_players() throws Exception {
		new Players("Pierre");
	}
}
