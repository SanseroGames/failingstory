package ch.failingstory;

import java.util.ArrayList;

import org.newdawn.slick.tiled.TiledMap;

import ch.failingstory.simulation.*;

public class MapManager {
	
	private TiledMap map;
	private ArrayList<IUnit> units;
	private ICellDefinition[] cells;
	private int cursorX;
	private int cursorY;

	public MapManager(String path) {
		try{
			//lade Map-Pfad
			String mapPath = ".\\res\\test.tmx";
			map = new TiledMap(mapPath);
			//Lade Zellendetails
			cells = new ICellDefinition[map.getWidth() * map.getHeight()];
			//lade Starteinheiten
			units = new ArrayList<IUnit>();
			units.add(new TestUnit(5,5,"Test1"));
			units.add(new TestUnit(16,4,"Wurst"));
			units.add(new TestUnit(20,16,"Spassvogel"));
			cursorX = map.getWidth() / 2;
			cursorY = map.getHeight() / 2;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the Map 
	 * @return The Map
	 */
	public TiledMap getMap() {
		return map;
	}

	/**
	 * ArrayList containing every Unit on the map
	 * @return ArrayList containig every Unit
	 */
	public ArrayList<IUnit> getUnits() {
		return units;
	}
	
	/**
	 * Returns the Celldefinition at the specified Position
	 * @param x - The X-Coordinate starting at 0
	 * @param y - The Y-Coordinate starting at 0
	 * @return The CellDefinition
	 */
	public ICellDefinition getCellAt(int x, int y){
		return cells[map.getWidth() * y + x];
	}
	
	public IUnit getUnitAt(int x, int y){
		for(IUnit unit:units){
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
}
