package ch.failingstory;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Interface for Components which compute Game related things
 * @author SanseroGames
 *
 */
public abstract class GameComponent implements IComponent{
	
	@Override
	public final void render(GameContainer container, Graphics g) throws SlickException{ }
	
	/**
	 * Method to update
	 * @param container The Main Frame
	 * @param delta Time in Millisecond since the last update call
	 */
	@Override
	public abstract void update(GameContainer container, int delta);
	
}
