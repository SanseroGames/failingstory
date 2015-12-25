package ch.failingstory.graphic;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.Mover;

import ch.failingstory.Index2;
import ch.failingstory.MapManager;
import ch.failingstory.ResourceManager;

public class CursorRenderer implements Mover{
	
	private MapManager manager;
	private Animation cursor;
	private Image[] arrow;
	
	public CursorRenderer(MapManager manager) throws SlickException{
		this.manager = manager;
		
		cursor = ResourceManager.cursor;
		
		arrow = ResourceManager.arrow;
	}
	
	public void render(Graphics g, GameContainer container) throws SlickException{
		int cellWidth = manager.getMap().getTileWidth();
		int cellHeight = manager.getMap().getTileHeight();
		if(manager.getSelectedUnit() != null)
			drawArrowToCursor(g,cellWidth,cellHeight);
		
		int curWidth = cellWidth + (cellWidth / 2);
		int curHeight = cellHeight + (cellHeight / 2);
		int curOffsetX = (curWidth - cellWidth) / 2;
		int curOffsetY = (curHeight - cellHeight) / 2;
		cursor.draw((manager.getCursorX() * cellWidth) - curOffsetX, (manager.getCursorY() * cellHeight) - curOffsetY,
				curWidth, curHeight);
	}
	
	
	private void drawArrowToCursor(Graphics g, int cellWidth, int cellHeight) {
		ArrayList<Index2> p = manager.getCursorPath();
		
		if (p != null && p.size() > 1) {
			for (int i = 0; i < p.size(); i++) {
				if (i == p.size() - 1) {
					if (p.get(i - 1).X < p.get(i).X)
						arrow[6].draw((p.get(i).X) * cellWidth, p.get(i).Y * cellHeight, cellWidth, cellHeight);
					if (p.get(i - 1).X > p.get(i).X)
						arrow[7].draw((p.get(i).X) * cellWidth, p.get(i).Y * cellHeight, cellWidth, cellHeight);
					if (p.get(i - 1).Y < p.get(i).Y)
						arrow[8].draw((p.get(i).X) * cellWidth, p.get(i).Y * cellHeight, cellWidth, cellHeight);
					if (p.get(i - 1).Y > p.get(i).Y)
						arrow[9].draw((p.get(i).X) * cellWidth, p.get(i).Y * cellHeight, cellWidth, cellHeight);
				} else if (i > 0) {
					if (i + 1 < p.size() && (p.get(i).X != p.get(i + 1).X || p.get(i).Y != p.get(i + 1).Y)) {
						if (((p.get(i).X < p.get(i + 1).X || p.get(i).X < p.get(i - 1).X)
								&& (p.get(i).Y < p.get(i + 1).Y || p.get(i).Y < p.get(i - 1).Y)))
							arrow[5].draw((p.get(i).X) * cellWidth, p.get(i).Y * cellHeight, cellWidth, cellHeight);
						else if (((p.get(i).X < p.get(i + 1).X || p.get(i).X < p.get(i - 1).X)
								&& (p.get(i).Y > p.get(i + 1).Y || p.get(i).Y > p.get(i - 1).Y)))
							arrow[4].draw((p.get(i).X) * cellWidth, p.get(i).Y * cellHeight, cellWidth, cellHeight);
						else if (((p.get(i).X > p.get(i + 1).X || p.get(i).X > p.get(i - 1).X)
								&& (p.get(i).Y > p.get(i + 1).Y || p.get(i).Y > p.get(i - 1).Y)))
							arrow[3].draw((p.get(i).X) * cellWidth, p.get(i).Y * cellHeight, cellWidth, cellHeight);
						else if (((p.get(i).X > p.get(i + 1).X || p.get(i).X > p.get(i - 1).X)
								&& (p.get(i).Y < p.get(i + 1).Y || p.get(i).Y < p.get(i - 1).Y)))
							arrow[2].draw((p.get(i).X) * cellWidth, p.get(i).Y * cellHeight, cellWidth, cellHeight);
						else {
							if (p.get(i).X == p.get(i - 1).X)
								arrow[1].draw((p.get(i).X) * cellWidth, p.get(i).Y * cellHeight, cellWidth, cellHeight);
							else
								arrow[0].draw((p.get(i).X) * cellWidth, p.get(i).Y * cellHeight, cellWidth, cellHeight);
						}
					}
				}
			}
		}
	}

}
