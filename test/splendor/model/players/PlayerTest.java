package splendor.model.players;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import splendor.exceptions.ColorPickedException;
import splendor.model.cards.LevelOneCards;
import splendor.model.gems.GemStock;
import splendor.model.gems.Gem;
import splendor.model.gems.PlayerGems;


public class PlayerTest {

	private Player a_player;
	
	@Before
	public void setUp() {
		a_player = new Player("Pierre");
	}
	
	@Test
	public void a_player_should_be_created_with_a_name() throws Exception {
		assertThat(a_player.name(), is("Pierre"));
	}

	@Test
	public void when_player_picks_3_gems_then_stock_decrease() throws Exception {
		GemStock gemStock = GemStock.initialise();
		a_player.pickThreeDifferentGems(gemStock, Gem.RED, Gem.GREEN, Gem.BLUE);
		assertThat(gemStock.numberOf(Gem.RED), is(6));
		assertThat(gemStock.numberOf(Gem.GREEN), is(6));
		assertThat(gemStock.numberOf(Gem.BLUE), is(6));
	}
	
	@Test
	public void a_new_player_dont_have_any_gem_at_the_beginning() throws Exception {
		PlayerGems playerGems = a_player.gemStock();
		assertThat(playerGems.isEmpty(), is(true));
	}
	
	@Test
	public void when_player_picks_gems_then_player_stock_is_increased() throws Exception {
		GemStock gemStock = GemStock.initialise();
		a_player.pickThreeDifferentGems(gemStock, Gem.RED, Gem.GREEN, Gem.BLUE);
		PlayerGems playerGems = a_player.gemStock();
		assertThat(playerGems.isEmpty(), is(false));
	}
	
	@Test
	public void when_player_picks_two_identical_gems_then_his_stock_contains_gems_picked() throws Exception {
		GemStock gemStock = GemStock.initialise();
		a_player.pickTwoIdenticalGems(gemStock, Gem.RED);
		PlayerGems playerGems = a_player.gemStock();
		
		assertThat(playerGems, equalTo(stockWithTwoRedGems()));
	}

	@Test
	public void when_player_picks_gems_then_his_stock_contains_gems_picked() throws Exception {
		GemStock gemStock = GemStock.initialise();
		a_player.pickThreeDifferentGems(gemStock, Gem.RED, Gem.GREEN, Gem.BLUE);
		PlayerGems playerGems = a_player.gemStock();
		
		assertThat(playerGems, equalTo(expectedPlayerGems()));
	}
	
	@Test(expected=ColorPickedException.class)
	public void on_a_three_gems_picks_player_could_not_pick_two_times_the_same_color() throws Exception {
		GemStock gemStock = GemStock.initialise();
		a_player.pickThreeDifferentGems(gemStock, Gem.RED, Gem.GREEN, Gem.RED);
	}

	@Test
	public void player_could_pick_a_card_in_his_hand() throws Exception {
		LevelOneCards a_card = new LevelOneCards();
		a_player.pickCard(a_card);
		PlayerHand expectedHand = new PlayerHand();
		expectedHand.add(a_card);
		assertThat(a_player.cardsInHand(), is(expectedHand));
	}
	
	
	private PlayerGems expectedPlayerGems() {
		PlayerGems expectedPlayerGems = new PlayerGems();
		expectedPlayerGems.add(Gem.RED);
		expectedPlayerGems.add(Gem.GREEN);
		expectedPlayerGems.add(Gem.BLUE);
		return expectedPlayerGems;
	}
	
	private PlayerGems stockWithTwoRedGems() {
		PlayerGems expectedPlayerGems = new PlayerGems();
		expectedPlayerGems.add(Gem.RED);
		expectedPlayerGems.add(Gem.RED);
		return expectedPlayerGems;
	}
	
}
