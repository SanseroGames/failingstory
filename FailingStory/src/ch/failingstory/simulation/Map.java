package ch.failingstory.simulation;

import ch.failingstory.IMap;
import ch.failingstory.IMapCellDefinition;

public class Map implements IMap{

	private int height;
	private int width;
	private IMapCellDefinition[] cells;
	
	public Map(int height, int width){
		cells = new IMapCellDefinition[height*width];
		this.height = height;
		this.width = width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public IMapCellDefinition getCellAt(int x, int y) {
		return cells[width*y+x];
	}

	@Override
	public void setCellDefintion(int x, int y, IMapCellDefinition definition) {
		cells[width*y+x] = definition;
	}

}
