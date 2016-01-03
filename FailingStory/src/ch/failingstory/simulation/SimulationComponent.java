package ch.failingstory.simulation;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.util.pathfinding.*;

import ch.failingstory.GameComponent;
import ch.failingstory.Index2;
import ch.failingstory.MapManager;
import ch.failingstory.input.InputComponent;

public class SimulationComponent extends GameComponent{

	private MapManager manager;
	private InputComponent input;

	public SimulationComponent(MapManager manager, InputComponent input) {
		this.manager = manager;
		this.input = input;
	}

	@Override
	public void update(GameContainer container, int delta) {
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
			if(selUnit != null){
				ArrayList<Index2> curPath = manager.getCursorPath();
				if(curPath != null){
					int diffX = Math.abs(selUnit.getX() - manager.getCursorX());
					int diffY = Math.abs(selUnit.getY() - manager.getCursorY());
					//Cursor in Range
					if(diffX + diffY <= selUnit.getWalkRange()){
						//Cursorpath to long
						if(curPath.size() > selUnit.getWalkRange() || curPath.size() == 0){
							AStarPathFinder find = new AStarPathFinder((TileBasedMap) manager.getMap(),
									selUnit.getWalkRange(), false);
							Path p = find.findPath(new EmptyMover(), selUnit.getX(), selUnit.getY(),
									manager.getCursorX(), manager.getCursorY());
							//no path found
							if(p !=null ){
								curPath.clear();
								for(int i=0; i<p.getLength();i++){
									curPath.add(new Index2(p.getX(i),p.getY(i)));
								}
							}else{
								if(curPath.size()==0){
									curPath.add(new Index2(selUnit.getX(),selUnit.getY()));
								}
							}
						}else{
							Index2 newCell = new Index2(manager.getCursorX(),manager.getCursorY());
							//Cell already in Path
							if(curPath.contains(newCell)){
								int index = curPath.indexOf(newCell);
								for(int i= index + 1; i < curPath.size();){
									curPath.remove(i);
								}
							}else{
								curPath.add(newCell);
							}
						}
					}else{
						if(curPath.size()>0)
							curPath.clear();
					}
				}else{
					manager.setCursorPath(new ArrayList<Index2>());
					manager.getCursorPath().add(new Index2(selUnit.getX(),selUnit.getY()));
					//May cause problems if cursor is not next to the Unit
					manager.getCursorPath().add(new Index2(manager.getCursorX(),manager.getCursorY()));
				}
				
			}else if(manager.getCursorPath() != null){
				manager.setCursorPath(null);
			}
		}
		
		//Check interaction
		if (input.isInteractPressed()) {
			Unit u = (Unit) manager.getUnitAt(manager.getCursorX(), manager.getCursorY());
			if (u == selUnit && u != null) {
					clearSelectedUnit();
			} else if(u != null && manager.getSelectedUnit() == null){
				manager.setSelectedUnit(u);
			}
			// Attack
			else if (u != null && u != selUnit) {
				if (u.getHP() <= selUnit.getStrength()) {
					u.changeHPBy(- (u.getHP()));
					System.out.println("Unit " + u.getName() + " lost all HP by Unit " + selUnit.getName() + "!");
					manager.deleteUnit(u);
					System.out.println("Unit " + u.getName() + " died!");
				}
				else if (u.getHP() > selUnit.getStrength()) {
					u.changeHPBy(-(selUnit.getStrength()));
					System.out.println("Unit " + u.getName() + " lost " + selUnit.getStrength() + " HP by Unit " + selUnit.getName() + "!");
					System.out.println("Unit " + u.getName() + " has " + u.getHP() + " left!");
				}
			}
			else{
				if(selUnit != null && Math.abs(manager.getCursorX()-selUnit.getX())+Math.abs(manager.getCursorY()-selUnit.getY()) <= selUnit.getWalkRange()){
					selUnit.setPosition(manager.getCursorX(), manager.getCursorY());
					clearSelectedUnit();
				}
			}
		}
		
		//Check Cancellation
		if(input.isBackPressed()){
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
