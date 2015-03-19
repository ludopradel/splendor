package splendor.model.players;

import java.util.ArrayList;
import java.util.List;

import splendor.exceptions.NotEnoughPlayerException;
import splendor.exceptions.TooMuchPlayersException;



public class Players {

	List<Player> players = new ArrayList<Player>();

	public Players() {
	}

	public Players(String... playersName) throws TooMuchPlayersException, NotEnoughPlayerException {
		for (String name : playersName) {
			players.add(new Player(name));
		}
		if (numbers() > 4)
			throw new TooMuchPlayersException();
		if (numbers() < 2)
			throw new NotEnoughPlayerException();
	}

	public Integer numbers() {
		return players.size();
	}

	public void add(Player player) {
		players.add(player);
	}

}
