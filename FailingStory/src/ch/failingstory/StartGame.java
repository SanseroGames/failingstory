package ch.failingstory;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StartGame extends StateBasedGame{

	private AppGameContainer container;
	
	public StartGame(String name) {
		super(name);
		try{
			container = new AppGameContainer(this);
			container.setDisplayMode(1280, 720, false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void run(){
		try{
			container.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
