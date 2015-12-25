package ch.failingstory.simulation;

import org.newdawn.slick.GameContainer;

import ch.failingstory.IGameComponent;
import ch.failingstory.MapManager;

public class SimulationComponent implements IGameComponent{

	private MapManager manager;

	public SimulationComponent(MapManager manager) {
		this.manager = manager;
	}

	@Override
	public void update(GameContainer container, int delta) {

	}
}
