package ch.failingstory.data;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.PathFindingContext;

import ch.failingstory.GameMap;

public class TestMap extends GameMap{

	public TestMap(String ref) throws SlickException {
		super(ref);
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
