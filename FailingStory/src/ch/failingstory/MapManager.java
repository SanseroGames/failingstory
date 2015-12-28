package ch.failingstory;

import java.util.List;
import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import ch.failingstory.simulation.*;

/**
 * Class that manages the data for maps.
 * @author SanseroGames
 *
 */
public class MapManager {
	
	/**
	 * The current Map the User is playing on
	 */
	private GameMap map;
	/**
	 * The currently selected Unit
	 */
	private Unit selectedUnit;
	/**
	 * X-Coordinate of the Cursor
	 */
	private int cursorX;
	/**
	 * Y-Coordinate of the Cursor
	 */
	private int cursorY;
	/**
	 * Contains the Coordinate for the Arrow the user uses to move the Units. <br>
	 * It's null, if no Unit is selected and empty if there's no way from the Unit to the Cursor
	 */
	private ArrayList<Index2> cursorPath;

	public MapManager(String path) throws SlickException{
		//lade Map-Pfad
		String mapPath = ".\\res\\test.tmx";
		map = new GameMap(mapPath);
		//lade Starteinheiten
		map.addUnit(new TestUnit(5,5,"Test1",3,1,0));
		map.addUnit(new TestUnit(16,4,"Wurst",6,3,3));
		map.addUnit(new TestUnit(20,16,"Spassvogel",12,5,2));
		cursorX = map.getWidth() / 2;
		cursorY = map.getHeight() / 2;
	}

	/**
	 * Returns the Map 
	 * @return The Map
	 */
	public TiledMap getMap() {
		return map;
	}

	/**
	 * Array containing every Unit on the map
	 * @return Array containig every Unit
	 */
	public List<IUnit> getUnits() {
		return map.getUnits();
	}
	
	/**
	 * Returns the Celldefinition at the specified Position
	 * @param x - The X-Coordinate starting at 0
	 * @param y - The Y-Coordinate starting at 0
	 * @return The CellDefinition
	 */
//	public ICellDefinition getCellAt(int x, int y){
//		return cells[map.getWidth() * y + x];
//	}
	/**
	 * Returns the Unit located at the given Position. Returns null if there isn't any
	 * @param x X-Coordinate of the Unit
	 * @param y Y-Coordinate of the Unit
	 * @return The Unit or null
	 */
	public IUnit getUnitAt(int x, int y){
		for(IUnit unit:map.getUnits()){
			if(unit.getX() == x && unit.getY() == y)
				return unit;
		}
		return null;
	}
	
	public int getCursorX(){
		return cursorX;
	}
	
	public void setCursorX(int value){
		if(value < 0){
			cursorX = 0;
		}else if(value > map.getWidth() - 1){
			cursorX = map.getWidth() - 1;
		}else{
			cursorX = value;
		}
	}
	
	public void changeCursorXby(int value){
		int newcur = cursorX + value;
		if(newcur < 0){
			cursorX = 0;
		}else if(newcur > map.getWidth() - 1){
			cursorX = map.getWidth() - 1;
		}else{
			cursorX = newcur;
		}	
	}
	
	public int getCursorY(){
		return cursorY;
	}
	
	public void setCursorY(int value){
		if(value < 0){
			cursorY = 0;
		}else if(value > map.getHeight() - 1){
			cursorY = map.getHeight() - 1;
		}else{
			cursorY = value;
		}
	}
	
	public void changeCursorYby(int value){
		int newcur = cursorY + value;
		if(newcur < 0){
			cursorY = 0;
		}else if(newcur > map.getWidth() - 1){
			cursorY = map.getWidth() - 1;
		}else{
			cursorY = newcur;
		}	
	}
	
	public void setSelectedUnit(Unit newUnit){
		selectedUnit = newUnit;
	}
	
	public Unit getSelectedUnit(){
		return selectedUnit;
	}

	public ArrayList<Index2> getCursorPath() {
		return cursorPath;
	}

	public void setCursorPath(ArrayList<Index2> cursorPath) {
		this.cursorPath = cursorPath;
	}
}
