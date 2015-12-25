package ch.failingstory;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Interface for Component wich should be able to draw on the Screen
 * @author SanseroGames
 *
 */
public interface IDrawableComponent{
	
	/**
	 * Method to render the Drawable Component
	 * @param container The GameFrame 
	 * @param g The Graphics to render to
	 * @throws SlickException 
	 */
	void render(GameContainer container, Graphics g) throws SlickException;
}
