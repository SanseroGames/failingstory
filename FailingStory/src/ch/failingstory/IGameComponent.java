package ch.failingstory;

import org.newdawn.slick.GameContainer;

/**
 * Interface for Components which compute Game related things
 * @author SanseroGames
 *
 */
public interface IGameComponent {
	
	/**
	 * Method to update
	 * @param container The Main Frame
	 * @param delta Time in Millisecond since the last update call
	 */
	void update(GameContainer container, int delta);
	
}
