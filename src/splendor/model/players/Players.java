package splendor.model.players;

import java.util.ArrayList;
import java.util.List;

import splendor.exceptions.NotEnoughPlayerException;
import splendor.exceptions.TooMuchPlayersException;



public class Players {

	List<Player> players = new ArrayList<Player>();

	public Players(String... playersName) throws TooMuchPlayersException, NotEnoughPlayerException {
		if (playersName.length > 4)
			throw new TooMuchPlayersException();
		if (playersName.length < 2)
			throw new NotEnoughPlayerException();
		
		for (String name : playersName) {
			players.add(new Player(name));
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Players))
			return false;
		
		Players otherPlayers = (Players) obj;
		return players.containsAll(otherPlayers.players);
	}
}
