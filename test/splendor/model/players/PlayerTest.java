package splendor.model.players;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import splendor.model.gems.Gem;
import splendor.model.gems.GemStock;
import splendor.model.gems.Gems;
import splendor.model.players.Player;


public class PlayerTest {
	private static final Gem RED = Gem.RED;
	private static final Gem GREEN = Gem.GREEN;
	private static final Gem BLUE = Gem.BLUE;
	

//	@Test
	public void a_player_could_pick_3_gems() throws Exception {
		Player player = new Player("Pierre");
		GemStock gemStock = GemStock.initialise();
		player.pickGemsFrom(gemStock, RED, GREEN, BLUE);
		assertThat(gemStock.numberOf(Gems.RED), is(6));
	}
	
	@Test
	public void a_player_should_be_created_with_a_name() throws Exception {
		Player player = new Player("Pierre");
		assertThat(player.name(), is("Pierre"));
	}
}
