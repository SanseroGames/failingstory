package ch.failingstory.graphic;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

import ch.failingstory.CursorMover;
import ch.failingstory.MapManager;

public class CursorRenderer {
	
	private MapManager manager;
	private Animation cursor;
	private Image[] arrow;
	
	public CursorRenderer(MapManager manager) throws SlickException{
		this.manager = manager;
		
		cursor = new Animation(new Image[] { new Image(".\\res\\cursor1.png"), new Image(".\\res\\cursor2.png") },
				new int[] { 1000, 400 });
		
		arrow = new Image[] { new Image(".\\res\\arrow_left_right.png"), new Image(".\\res\\arrow_top_bottom.png"),
				new Image(".\\res\\arrow_left_bottom.png"), new Image(".\\res\\arrow_left_top.png"),
				new Image(".\\res\\arrow_right_top.png"), new Image(".\\res\\arrow_right_bottom.png"),
				new Image(".\\res\\arrow_left_right_head.png"), new Image(".\\res\\arrow_right_left_head.png"),
				new Image(".\\res\\arrow_top_bottom_head.png"), new Image(".\\res\\arrow_bottom_top_head.png") };

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
		AStarPathFinder find = new AStarPathFinder((TileBasedMap) manager.getMap(),
				manager.getSelectedUnit().getWalkRange(), false);
		Path p = find.findPath(new CursorMover(), manager.getSelectedUnit().getX(), manager.getSelectedUnit().getY(),
				manager.getCursorX(), manager.getCursorY());
		if (p != null) {
			for (int i = 0; i < p.getLength(); i++) {
				if (i == p.getLength() - 1) {
					if (p.getX(i - 1) < p.getX(i))
						arrow[6].draw((p.getX(i)) * cellWidth, p.getY(i) * cellHeight, cellWidth, cellHeight);
					if (p.getX(i - 1) > p.getX(i))
						arrow[7].draw((p.getX(i)) * cellWidth, p.getY(i) * cellHeight, cellWidth, cellHeight);
					if (p.getY(i - 1) < p.getY(i))
						arrow[8].draw((p.getX(i)) * cellWidth, p.getY(i) * cellHeight, cellWidth, cellHeight);
					if (p.getY(i - 1) > p.getY(i))
						arrow[9].draw((p.getX(i)) * cellWidth, p.getY(i) * cellHeight, cellWidth, cellHeight);
				} else if (i > 0) {
					if (i + 1 < p.getLength() && (p.getX(i) != p.getX(i + 1) || p.getY(i) != p.getY(i + 1))) {
						if (((p.getX(i) < p.getX(i + 1) || p.getX(i) < p.getX(i - 1))
								&& (p.getY(i) < p.getY(i + 1) || p.getY(i) < p.getY(i - 1))))
							arrow[5].draw((p.getX(i)) * cellWidth, p.getY(i) * cellHeight, cellWidth, cellHeight);
						else if (((p.getX(i) < p.getX(i + 1) || p.getX(i) < p.getX(i - 1))
								&& (p.getY(i) > p.getY(i + 1) || p.getY(i) > p.getY(i - 1))))
							arrow[4].draw((p.getX(i)) * cellWidth, p.getY(i) * cellHeight, cellWidth, cellHeight);
						else if (((p.getX(i) > p.getX(i + 1) || p.getX(i) > p.getX(i - 1))
								&& (p.getY(i) > p.getY(i + 1) || p.getY(i) > p.getY(i - 1))))
							arrow[3].draw((p.getX(i)) * cellWidth, p.getY(i) * cellHeight, cellWidth, cellHeight);
						else if (((p.getX(i) > p.getX(i + 1) || p.getX(i) > p.getX(i - 1))
								&& (p.getY(i) < p.getY(i + 1) || p.getY(i) < p.getY(i - 1))))
							arrow[2].draw((p.getX(i)) * cellWidth, p.getY(i) * cellHeight, cellWidth, cellHeight);
						else {
							if (p.getX(i) == p.getX(i - 1))
								arrow[1].draw((p.getX(i)) * cellWidth, p.getY(i) * cellHeight, cellWidth, cellHeight);
							else
								arrow[0].draw((p.getX(i)) * cellWidth, p.getY(i) * cellHeight, cellWidth, cellHeight);
						}
					}
				}
			}
		}
	}

}
