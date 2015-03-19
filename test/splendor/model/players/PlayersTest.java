package splendor.model.players;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class PlayersTest {
	
	@Test
	public void player_list_should_initially_be_empty() throws Exception {
		Players players = new Players();
		assertThat(players.numbers(), is(0));
	}
	
	@Test
	public void player_could_be_added() throws Exception {
		Players players = new Players();
		players.add(new Player("Pierre"));
		assertThat(players.numbers(), is(1));
	}
}
