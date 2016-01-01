package ch.failingstory;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface IComponent {

	void render(GameContainer container, Graphics g) throws SlickException;
	
	void update(GameContainer container, int delta);
	
}
