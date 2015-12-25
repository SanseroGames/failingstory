package ch.failingstory.graphic;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

import ch.failingstory.IDrawableComponent;
import ch.failingstory.IGameComponent;
import ch.failingstory.IUnit;
import ch.failingstory.Index2;
import ch.failingstory.MapManager;
import ch.failingstory.ResourceManager;
import ch.failingstory.input.InputComponent;
import ch.failingstory.simulation.Unit;

public class MapUI implements IDrawableComponent, IGameComponent {

	private MapManager manager;
	private InputComponent input;
	private Animation selectedField;
	private CursorRenderer cursor;
	
	public MapUI(InputComponent input, MapManager manager) throws SlickException{
		this.manager = manager;
		this.input = input;
		
		selectedField = ResourceManager.markedField;
		
		cursor = new CursorRenderer(manager);
	}
	
	 /**
	  * 
	  */
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// Draw selection
		// TODO: path finder to check if cell is blocked
		if (manager.getSelectedUnit() != null) {
			drawUnitRange();
		}
		
		cursor.render(g, container);
	}
	
	private void drawUnitRange(){
		IUnit selUnit = manager.getSelectedUnit();
		int cellWidth = manager.getMap().getTileWidth();
		int cellHeight = manager.getMap().getTileHeight();
		int wr = selUnit.getWalkRange();
		int xar = selUnit.getMaxAttackRange();
		int nar = selUnit.getMinAttackRange();
		for (int x = -(wr + xar); x <= wr + xar; x++) {
			for (int y = -(wr + xar - Math.abs(x)); y <= (wr + xar - Math.abs(x)); y++) {
				if (Math.abs(x) + Math.abs(y) > wr && Math.abs(x) + Math.abs(y) >= wr + nar) {
					selectedField.draw(((selUnit.getX() + x) * cellWidth) + 1,
							(selUnit.getY() + y) * cellHeight + 1, cellWidth - 2, cellHeight - 2,
							new Color(238f / 255f, 69f / 255f, 49f / 255f, 0.8f));
				} else if (Math.abs(x) + Math.abs(y) <= wr) {
					if (x != 0 || y != 0) {
						selectedField.draw(((selUnit.getX() + x) * cellWidth) + 1,
								(selUnit.getY() + y) * cellHeight + 1, cellWidth - 2, cellHeight - 2,
								new Color(36f / 255f, 126f / 255f, 248f / 255F, 0.8f));
					}
				}
			}
		}
	}

	@Override
	public void update(GameContainer container, int delta) {
		Index2 cursorMove = new Index2(0,0);		
		
		//Move Cursor
		if (input.isLeftPressed())
			cursorMove.X--;

		if (input.isRightPressed())
			cursorMove.X++;
			
		if (input.isUpPressed())
			cursorMove.Y--;

		if (input.isDownPressed())
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
							Path p = find.findPath(cursor, selUnit.getX(), selUnit.getY(),
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
					manager.setSelectedUnit(null);
			} else if(u != null)
				manager.setSelectedUnit(u);
			else{
				if(selUnit != null && Math.abs(manager.getCursorX()-selUnit.getX())+Math.abs(manager.getCursorY()-selUnit.getY()) <= selUnit.getWalkRange()){
					selUnit.setPosition(manager.getCursorX(), manager.getCursorY());
					manager.setSelectedUnit(null);
				}
			}
		}
		
		//Check Cancellation
		if(input.isBackPressed()){
			manager.setSelectedUnit(null);
		}
		
		//Debugging
		if(input.isTestPressed()){
			if (ResourceManager.gridBlend >= 0.7f){
				testGrid = true;
			}else if (ResourceManager.gridBlend <= 0f){
				testGrid = false;
			}
			if(testGrid){
				ResourceManager.gridBlend -= 0.01f;
			}else{
				ResourceManager.gridBlend += 0.01f;
			}
		}
	}
	
	private boolean testGrid;
}
