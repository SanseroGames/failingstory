package ch.failingstory.start;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import ch.failingstory.MapManager;
import ch.failingstory.ResourceManager;
import ch.failingstory.graphic.MapScreen;
import ch.failingstory.graphic.MapUI;
import ch.failingstory.input.InputComponent;
import ch.failingstory.simulation.SimulationComponent;

public class StartGame extends BasicGame {

	/**
	 * The Window the game is running into
	 */
	private AppGameContainer container;
	/**
	 * The manager for the Maps
	 */
	private MapManager manager;
	
	/**
	 * The Component that renders the Map
	 */
	private MapScreen mapScreen;
	/**
	 * Renders the UI that is use for playing the map
	 */
	private MapUI mapUI;
	
	/**
	 * Component that handels the Input
	 */
	private InputComponent input;
	/**
	 * Component that simulates the game
	 */
	private SimulationComponent simulation;

	public StartGame(String name) throws SlickException{
		super(name);
		container = new AppGameContainer(this);
		container.setDisplayMode(25*32, 25*32, false);
		container.setTargetFrameRate(60);
		container.setIcon(ResourceManager.iconPath);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		mapScreen.render(container, g);
		mapUI.render(container, g);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		ResourceManager.initialize();
		input = new InputComponent(container);
		manager = new MapManager(".\\res\\test.map");
		simulation = new SimulationComponent(manager);
		mapScreen = new MapScreen(manager);
		mapUI = new MapUI(input, manager);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		mapUI.update(container, delta);
		simulation.update(container, delta);
		input.update(container, delta);
	}
	
	/**
	 * Runs the game
	 * @throws SlickException
	 */
	public void run() throws SlickException{
		container.start();
	}
}
