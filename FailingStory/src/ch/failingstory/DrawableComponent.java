package ch.failingstory;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Interface for Component wich should be able to draw on the Screen
 * @author SanseroGames
 *
 */
public abstract class DrawableComponent implements IComponent{
	
	/**
	 * Method to render the Drawable Component
	 * @param container The GameFrame 
	 * @param g The Graphics to render to
	 * @throws SlickException 
	 */
	@Override
	public abstract void render(GameContainer container, Graphics g) throws SlickException;
	
	@Override
	public final void update(GameContainer container, int delta){ }
	
}
