package ch.failingstory.start;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import ch.failingstory.MapManager;
import ch.failingstory.graphic.MapScreen;

public class StartGame extends StateBasedGame {

	private AppGameContainer container;
	private MapManager manager;
	private MapScreen mapScreen;
	public static final int MAPSCREEN = 0;

	public StartGame(String name) {
		super(name);
		try {
			container = new AppGameContainer(this);
			container.setDisplayMode(1280, 720, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		manager = new MapManager(".\\res\\test.map");
		mapScreen = new MapScreen(MAPSCREEN, manager);
		this.addState(mapScreen);
	}

	public void run() {
		try {
			container.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
