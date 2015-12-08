package ch.failingstory;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class GameMap extends TiledMap implements TileBasedMap {

	public GameMap(String ref) throws SlickException {
		super(ref);
	}

	@Override
	public int getWidthInTiles() {
		return super.getWidth();
	}

	@Override
	public int getHeightInTiles() {
		return super.getHeight();
	}

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

}
