package splendor.model.players;

import java.util.ArrayList;
import java.util.List;



public class Players {

	List<Player> players = new ArrayList<Player>();

	public Players() {
	}

	public Integer numbers() {
		return players.size();
	}

	public void add(Player player) {
		players.add(player);
	}

}
