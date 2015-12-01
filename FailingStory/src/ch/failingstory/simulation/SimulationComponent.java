package ch.failingstory.simulation;

import org.newdawn.slick.GameContainer;

import ch.failingstory.IUnit;
import ch.failingstory.MapManager;
import ch.failingstory.input.InputComponent;

public class SimulationComponent {
	
	private InputComponent input;
	private MapManager manager;
	private int stamp;
	
	public SimulationComponent(InputComponent input, MapManager manager){
		this.input = input;
		this.manager = manager;
	}
	
	public void update(GameContainer container, int delta){
		stamp += delta;
		if(input.isLeftPressed() && stamp > 100){
			manager.setCursorX(manager.getCursorX()-1);
			stamp = 0;
		}
		if(input.isUpPressed() && stamp > 100){
			manager.setCursorY(manager.getCursorY()-1);
			stamp = 0;
		}
		if(input.isDownPressed() && stamp > 100){
			manager.setCursorY(manager.getCursorY()+1);
			stamp = 0;
		}
		if(input.isRightPressed() && stamp > 100){
			manager.setCursorX(manager.getCursorX()+1);
			stamp = 0;
		}
		if (input.isActionPressed()) {
			IUnit u = manager.getUnitAt(manager.getCursorX(), manager.getCursorY());
			System.out.println("Clicked: " + manager.getCursorX() + "/" + manager.getCursorY() + ", there's Unit: "
					+ (u != null ? u.getName() : "null"));
		}
	}
}
