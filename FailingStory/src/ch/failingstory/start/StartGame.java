package ch.failingstory.start;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import ch.failingstory.MapManager;
import ch.failingstory.graphic.MapScreen;
import ch.failingstory.input.InputComponent;
import ch.failingstory.simulation.SimulationComponent;

public class StartGame extends BasicGame {

	private AppGameContainer container;
	private MapManager manager;
	private MapScreen mapScreen;
	private InputComponent input;
	private SimulationComponent simulation;

	public StartGame(String name) throws SlickException{
		super(name);
		container = new AppGameContainer(this);
		container.setDisplayMode(25*32, 25*32, false);
		container.setTargetFrameRate(60);
		container.setIcon(".\\res\\icon.png");
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		mapScreen.render(container, g);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		input = new InputComponent(container);
		manager = new MapManager(".\\res\\test.map");
		simulation = new SimulationComponent(input, manager);
		mapScreen = new MapScreen(manager);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		simulation.update(container, delta);
		input.update(container, delta);
	}
	
	public void run() throws SlickException{
		container.start();
	}
}
