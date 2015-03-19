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
		assertThat(gemStock.numberOf(Gems.BLUE), is(7));
		assertThat(gemStock.numberOf(Gems.BLACK), is(7));
		assertThat(gemStock.numberOf(Gems.GOLD), is(5));
		assertThat(gemStock.numberOf(Gems.GREEN), is(7));
		assertThat(gemStock.numberOf(Gems.RED), is(7));
		assertThat(gemStock.numberOf(Gems.WHITE), is(7));
		
	}
	
	@Test
	public void pick_a_gem_reduce_stock_quantity() throws Exception {
		GemStock gemStock = GemStock.initialise();
		gemStock.pick(Gems.BLACK);
		assertThat(gemStock.numberOf(Gems.BLACK), is(6));
	}
	
}
