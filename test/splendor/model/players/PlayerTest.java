package splendor.model.players;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import splendor.model.gems.GemStock;
import splendor.model.gems.Gem;
import splendor.model.gems.PlayerGems;


public class PlayerTest {

	
	@Test
	public void a_player_should_be_created_with_a_name() throws Exception {
		Player player = new Player("Pierre");
		assertThat(player.name(), is("Pierre"));
	}

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
	public void a_new_player_dont_have_any_gem_at_the_beginning() throws Exception {
		Player player = new Player("Pierre");
		PlayerGems playerGems = player.gemStock();
		assertThat(playerGems.isEmpty(), is(true));
	}
	
	@Test
	public void when_player_picks_gems_then_player_stock_is_increased() throws Exception {
		Player player = new Player("Pierre");
		GemStock gemStock = GemStock.initialise();
		player.pickGemsFrom(gemStock, Gem.RED, Gem.GREEN, Gem.BLUE);
		PlayerGems playerGems = player.gemStock();
		assertThat(playerGems.isEmpty(), is(false));
	}
	
	@Test
	public void when_player_picks_gems_then_his_stock_contains_gems_picked() throws Exception {
		Player player = new Player("Pierre");
		GemStock gemStock = GemStock.initialise();
		player.pickGemsFrom(gemStock, Gem.RED, Gem.GREEN, Gem.BLUE);
		PlayerGems playerGems = player.gemStock();
		
		assertThat(playerGems, equalTo(expectedPlayerGems()));
	}

	private PlayerGems expectedPlayerGems() {
		PlayerGems expectedPlayerGems = new PlayerGems();
		expectedPlayerGems.add(Gem.RED);
		expectedPlayerGems.add(Gem.GREEN);
		expectedPlayerGems.add(Gem.BLUE);
		return expectedPlayerGems;
	}
	
}
