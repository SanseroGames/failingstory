package ch.failingstory.start;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import ch.failingstory.IComponent;
import ch.failingstory.MapManager;
import ch.failingstory.ResourceManager;
import ch.failingstory.graphic.MapUI;
import ch.failingstory.input.InputComponent;
import ch.failingstory.simulation.MapSimulator;

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
	private MapSimulator simulation;
	
	private List<IComponent> components = new ArrayList<IComponent>();
	
	public StartGame(String name) throws SlickException{
		super(name);
		container = new AppGameContainer(this);
		container.setDisplayMode(25*32, 25*32, false);
		container.setTargetFrameRate(60);
		container.setIcon(ResourceManager.iconPath);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		ResourceManager.initialize();
		
		input = new InputComponent(container);
		components.add(input);
		
		manager = new MapManager(".\\res\\test.map");
		
		simulation = new MapSimulator(manager, input);
		components.add(simulation);
				
		mapUI = new MapUI(manager);
		components.add(mapUI);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		for(IComponent c : components)
			c.render(container, g);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		for(IComponent c : components)
			c.update(container, delta);
	}
	
	/**
	 * Runs the game
	 * @throws SlickException
	 */
	public void run() throws SlickException{
		container.start();
	}
}
