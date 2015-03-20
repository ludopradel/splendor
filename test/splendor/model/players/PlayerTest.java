package splendor.model.players;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import splendor.model.gems.GemStock;
import splendor.model.gems.Gem;


public class PlayerTest {

	@Test
	public void when_player_picks_3_gems_then_stock_decrease() throws Exception {
		Player player = new Player("Pierre");
		GemStock gemStock = GemStock.initialise();
		player.pickGemsFrom(gemStock, Gem.RED, Gem.GREEN, Gem.BLUE);
		assertThat(gemStock.numberOf(Gem.RED), is(6));
		assertThat(gemStock.numberOf(Gem.GREEN), is(6));
		assertThat(gemStock.numberOf(Gem.BLUE), is(6));
	}
	
	@Test
	public void a_player_should_be_created_with_a_name() throws Exception {
		Player player = new Player("Pierre");
		assertThat(player.name(), is("Pierre"));
	}
}
