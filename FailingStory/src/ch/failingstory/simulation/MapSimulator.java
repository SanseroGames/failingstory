package ch.failingstory.simulation;

import org.newdawn.slick.GameContainer;

import ch.failingstory.input.InputComponent;
import ch.failingstory.*;

public class MapSimulator extends GameComponent{

	private MapManager manager;
	private InputComponent input;

	public MapSimulator(MapManager manager, InputComponent input) {
		this.manager = manager;
		this.input = input;
	}

	//Change to Eventbased system
	
	@Override
	public void update(GameContainer container, int delta) {
		//TODO: Cleanup!
		
		Index2 cursorMove = new Index2(0,0);		
		
		//Move Cursor
		if (input.isLeftPressed())
			cursorMove.X--;

		else if (input.isRightPressed())
			cursorMove.X++;
			
		else if (input.isUpPressed())
			cursorMove.Y--;

		else if (input.isDownPressed())
			cursorMove.Y++;
		
		//Calculate Cursorpath
		Unit selUnit = manager.getSelectedUnit();
		if(!cursorMove.equals(Index2.Zero)){
			manager.changeCursorXby(cursorMove.X);
			manager.changeCursorYby(cursorMove.Y);
			if(!manager.isSelectedUnitMoved()){
				if(selUnit != null){
					manager.setCursorPath(CursorMover.calculateCursorPath(manager.getCursorX(), manager.getCursorY(), selUnit, manager.getCursorPath(), manager.getMap()));
				}else if(manager.getCursorPath() != null){
					manager.setCursorPath(null);
				}
			}
		}
		
		//Check interaction
		if (input.isInteractPressed()) {
			Unit u = (Unit) manager.getUnitAt(manager.getCursorX(), manager.getCursorY());
			//Change to nice Statebased checking
			if(manager.isSelectedUnitMoved()){	
				// Attack
				if (u != null && u != selUnit) {
					UnitHost host = new UnitHost(selUnit);
					host.attack(u);
					if(u.getHP() == 0){
						System.out.println("Unit " + u.getName() + " lost all HP by Unit " + selUnit.getName() + "!");
						manager.deleteUnit(u);
						System.out.println("Unit " + u.getName() + " died!");
					}
					else  {
						System.out.println("Unit " + u.getName() + " lost " + selUnit.getStrength() + " HP by Unit " + selUnit.getName() + "!");
						System.out.println("Unit " + u.getName() + " has " + u.getHP() + " left!");
					}
					selUnit.setPosition(manager.getSelectedPosition().X,manager.getSelectedPosition().Y);
					clearSelectedUnit();
				}else if(manager.getCursorX() == manager.getSelectedPosition().X && manager.getCursorY() == manager.getSelectedPosition().Y){
					selUnit.setPosition(manager.getSelectedPosition().X,manager.getSelectedPosition().Y);
					clearSelectedUnit();
				}
			}
			else{
				if (u == selUnit && u != null) {
					clearSelectedUnit();
				}else if(u != null && manager.getSelectedUnit() == null){
					manager.setSelectedUnit(u);
				}
				if(selUnit != null && u == null && Math.abs(manager.getCursorX()-selUnit.getX())+Math.abs(manager.getCursorY()-selUnit.getY()) <= selUnit.getWalkRange()){
					manager.setSelectPosition(new Index2(manager.getCursorX(), manager.getCursorY()));
				}
			}
		}
		
		//Check Cancellation
		if(input.isBackPressed()){
			if(manager.isSelectedUnitMoved())
				manager.setSelectPosition(null);
			else
				clearSelectedUnit();
		}
		
		//Debugging
		if(input.isTestPressed()){

		}
	}
	
	public void clearSelectedUnit(){
		manager.setSelectedUnit(null);
		manager.setCursorPath(null);
	}
}
