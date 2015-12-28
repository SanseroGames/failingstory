package ch.failingstory;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class GameMap extends TiledMap implements TileBasedMap {
	
	private ArrayList<IUnit> units;

	public GameMap(String ref) throws SlickException {
		super(ref);
		units = new ArrayList<IUnit>();
	}

	@Override
	public int getWidthInTiles() {
		return super.getWidth();
	}

	@Override
	public int getHeightInTiles() {
		return super.getHeight();
	}

	//Pathfinding
	@Override
	public void pathFinderVisited(int x, int y) {
		
	}

	@Override
	public boolean blocked(PathFindingContext context, int tx, int ty) {
		return false;
	}

	@Override
	public float getCost(PathFindingContext context, int tx, int ty) {
		return 1;
	}
	
	//Units
	
	public void addUnit(IUnit unit){
		if(unit != null)
			units.add(unit);
	}
	
	public List<IUnit> getUnits(){
		return units;
	}
}
