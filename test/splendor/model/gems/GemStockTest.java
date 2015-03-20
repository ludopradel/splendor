package splendor.model.gems;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GemStockTest {

	@Test
	public void initial_number_of_gems_is_40() throws Exception {
		GemStock gemStock = GemStock.initialise();
		assertThat(gemStock.count(), is(40));
	}
	
	@Test
	public void initial_number_of_blue_gems_is_7() throws Exception {
		GemStock gemStock = GemStock.initialise();
		assertThat(gemStock.numberOf(Gem.BLUE), is(7));
		assertThat(gemStock.numberOf(Gem.BLACK), is(7));
		assertThat(gemStock.numberOf(Gem.GOLD), is(5));
		assertThat(gemStock.numberOf(Gem.GREEN), is(7));
		assertThat(gemStock.numberOf(Gem.RED), is(7));
		assertThat(gemStock.numberOf(Gem.WHITE), is(7));
		
	}
	
	@Test
	public void pick_a_gem_reduce_stock_quantity() throws Exception {
		GemStock gemStock = GemStock.initialise();
		gemStock.pick(Gem.BLACK);
		assertThat(gemStock.numberOf(Gem.BLACK), is(6));
	}
	
}
