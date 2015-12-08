package ch.failingstory;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface IDrawableComponent{
	
	void render(GameContainer container, Graphics g) throws SlickException;
}
