package ch.failingstory;

import java.util.ArrayList;

import org.newdawn.slick.tiled.TiledMap;

import ch.failingstory.simulation.Unit;

public class MapManager {

	private TiledMap map;
	private ArrayList<IUnit> units;
	private ICellDefinition[] cells;

	public MapManager(String path) {
		try{
			//lade Map-Pfad
			String mapPath = ".\\res\\test.tmx";
			map = new TiledMap(mapPath);
			//Lade Zellendetails
			cells = new ICellDefinition[map.getWidth() * map.getHeight()];
			//lade Starteinheiten
			units = new ArrayList<IUnit>();
//			units.add(new Unit(5,5));
//			units.add(new Unit(16,4));
//			units.add(new Unit(20,16));
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
}
