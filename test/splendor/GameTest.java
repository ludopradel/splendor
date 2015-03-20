package splendor;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import splendor.model.cards.LevelOneCards;
import splendor.model.cards.LevelThreeCards;
import splendor.model.cards.LevelTwoCards;
import splendor.model.cards.VisibleLevelOneCards;
import splendor.model.cards.VisibleLevelThreeCards;
import splendor.model.cards.VisibleLevelTwoCards;
import splendor.model.gems.GemStock;
import splendor.model.lords.Lords;
import splendor.model.players.Players;

public class GameTest {
	Game game;
	
	@Before
	public void setUp() throws Exception {
		game = new Game("Joueur 1", "Joueur 2");
	}
	
	@Test
	public void game_is_created_with_four_visible_level_one_cards() throws Exception {
		LevelOneCards levelOneCards = game.levelOneCards();
		VisibleLevelOneCards visibleLevelOneCards = levelOneCards.visibleCards();
		assertThat(visibleLevelOneCards.count(), is(4));
	}
	
	@Test
	public void game_is_created_with_four_visible_level_two_cards() throws Exception {
		LevelTwoCards levelTwoCards = game.levelTwoCards();
		VisibleLevelTwoCards visibleLevelTwoCards = levelTwoCards.visibleCards();
		assertThat(visibleLevelTwoCards.count(), is(4));
	}
	
	@Test
	public void game_is_created_with_four_visible_level_three_cards() throws Exception {
		LevelThreeCards levelThreeCards = game.levelThreeCards();
		VisibleLevelThreeCards visibleLevelThreeCards = levelThreeCards.visibleCards();
		assertThat(visibleLevelThreeCards.count(), is(4));
	}
	
	@Test
	public void game_is_created_with_five_lords() throws Exception {
		Lords lords = game.lords();
		assertThat(lords.count(), is(5));
	}
	
	@Test
	public void game_is_created_with_all_chips() throws Exception {
		GemStock gems = game.gems();
		assertThat(gems.count(), is(40));
	}
	
	@Test
	public void game_should_be_created_with_players() throws Exception {
		Game game = new Game("Pierre", "Paul");
		Players players = game.players();
		
		Players playersExpected = new Players("Pierre", "Paul");
		assertThat(players, equalTo(playersExpected));
	}
	
}
