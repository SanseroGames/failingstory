package ch.failingstory.simulation;

import org.newdawn.slick.GameContainer;

import ch.failingstory.IGameComponent;
import ch.failingstory.IUnit;
import ch.failingstory.MapManager;
import ch.failingstory.input.InputComponent;

public class SimulationComponent implements IGameComponent{

	private InputComponent input;
	private MapManager manager;

	public SimulationComponent(InputComponent input, MapManager manager) {
		this.input = input;
		this.manager = manager;
	}

	@Override
	public void update(GameContainer container, int delta) {
		if (input.isLeftPressed())
			manager.changeCursorXby(-1);

		if (input.isRightPressed())
			manager.changeCursorXby(1);

		if (input.isUpPressed())
			manager.changeCursorYby(-1);

		if (input.isDownPressed())
			manager.changeCursorYby(1);

		if (input.isInteractPressed()) {
			Unit u = (Unit) manager.getUnitAt(manager.getCursorX(), manager.getCursorY());
			if (u == manager.getSelectedUnit() && u != null) {
					manager.setSelectedUnit(null);
			} else if(u != null)
				manager.setSelectedUnit(u);
			else{
				if(manager.getSelectedUnit() != null && Math.abs(manager.getCursorX()-manager.getSelectedUnit().getX())+Math.abs(manager.getCursorY()-manager.getSelectedUnit().getY()) <= manager.getSelectedUnit().getWalkRange()){
					manager.getSelectedUnit().setPosition(manager.getCursorX(), manager.getCursorY());
					manager.setSelectedUnit(null);
				}
			}
			
			System.out.println("Unit selected: " + (manager.getSelectedUnit() != null ? manager.getSelectedUnit().getName() : "null"));
		}
		
		if(input.isBackPressed()){
			manager.setSelectedUnit(null);
		}
	}
}
