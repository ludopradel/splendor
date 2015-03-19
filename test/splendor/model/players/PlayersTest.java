package splendor.model.players;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class PlayersTest {
	
	@Test
	public void player_list_is_initially_empty() throws Exception {
		Players players = new Players();
		assertThat(players.numbers(), is(0));
	}
}
