package ch.failingstory.graphic;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import ch.failingstory.IUnit;
import ch.failingstory.MapManager;

public class MapScreen extends BasicGameState{

	private MapManager manager;
	private int screenID;
	
	public MapScreen(int id,MapManager manager){
		this.manager = manager;
		screenID = id;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		manager.getMap().render(0,0);
		
		int texWidth = manager.getMap().getTileWidth();
		int texHeight = manager.getMap().getTileHeight();
		
		for (IUnit unit : manager.getUnits()) {
			if(unit!=null)
				unit.getAnimation().draw(((int)unit.getX()) * texWidth, ((int)unit.getY()) * texHeight,texWidth,texHeight);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return screenID;
	}
}
