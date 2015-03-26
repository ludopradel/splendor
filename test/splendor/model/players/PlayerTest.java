package splendor.model.players;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import splendor.exceptions.ColorPickedException;
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
		player.pickThreeDifferentGems(gemStock, Gem.RED, Gem.GREEN, Gem.BLUE);
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
		player.pickThreeDifferentGems(gemStock, Gem.RED, Gem.GREEN, Gem.BLUE);
		PlayerGems playerGems = player.gemStock();
		assertThat(playerGems.isEmpty(), is(false));
	}
	
	@Test
	public void when_player_picks_two_identical_gems_then_his_stock_contains_gems_picked() throws Exception {
		Player player = new Player("Pierre");
		GemStock gemStock = GemStock.initialise();
		player.pickTwoIdenticalGems(gemStock, Gem.RED);
		PlayerGems playerGems = player.gemStock();
		
		PlayerGems expectedPlayerGems = new PlayerGems();
		expectedPlayerGems.add(Gem.RED);
		expectedPlayerGems.add(Gem.RED);
		
		assertThat(playerGems, equalTo(expectedPlayerGems));
	}
	
	@Test
	public void when_player_picks_gems_then_his_stock_contains_gems_picked() throws Exception {
		Player player = new Player("Pierre");
		GemStock gemStock = GemStock.initialise();
		player.pickThreeDifferentGems(gemStock, Gem.RED, Gem.GREEN, Gem.BLUE);
		PlayerGems playerGems = player.gemStock();
		
		assertThat(playerGems, equalTo(expectedPlayerGems()));
	}
	
	@Test(expected=ColorPickedException.class)
	public void on_a_three_gems_picks_player_could_not_pick_two_times_the_same_color() throws Exception {
		Player player = new Player("Pierre");
		GemStock gemStock = GemStock.initialise();
		player.pickThreeDifferentGems(gemStock, Gem.RED, Gem.GREEN, Gem.RED);
	}

	private PlayerGems expectedPlayerGems() {
		PlayerGems expectedPlayerGems = new PlayerGems();
		expectedPlayerGems.add(Gem.RED);
		expectedPlayerGems.add(Gem.GREEN);
		expectedPlayerGems.add(Gem.BLUE);
		return expectedPlayerGems;
	}
	
}
