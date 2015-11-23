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

	public TiledMap getMap() {
		return map;
	}

	public ArrayList<IUnit> getUnits() {
		return units;
	}
	
	public ICellDefinition getCellAt(int x, int y){
		return cells[map.getWidth() * y + x];
	}
}
