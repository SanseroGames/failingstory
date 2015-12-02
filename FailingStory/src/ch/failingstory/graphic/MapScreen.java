package ch.failingstory.graphic;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.failingstory.IUnit;
import ch.failingstory.MapManager;

public class MapScreen {

	private MapManager manager;
	private Animation cursor;

	public MapScreen(MapManager manager) throws SlickException {
		this.manager = manager;
		cursor = new Animation(new Image[] { new Image(".\\res\\cursor1.png"), new Image(".\\res\\cursor2.png")}, new int[] {1000,400});
	}

	public void render(GameContainer container, Graphics g) throws SlickException {
		int cellWidth = manager.getMap().getTileWidth();
		int cellHeight = manager.getMap().getTileHeight();

		// Draw Map
		manager.getMap().render(0, 0);

		// Draw Units
		for (IUnit unit : manager.getUnits()) {
			if (unit != null)
				unit.getAnimation().draw(((int) unit.getX()) * cellWidth, ((int) unit.getY()) * cellHeight, cellWidth,
						cellHeight);
		}
		int curWidth = cellWidth + (cellWidth / 2);
		int curHeight = cellHeight + (cellHeight / 2);
		int curOffsetX = (curWidth - cellWidth) / 2;
		int curOffsetY = (curHeight - cellHeight) / 2;
		cursor.draw((manager.getCursorX() * cellWidth) - curOffsetX, (manager.getCursorY() * cellHeight) - curOffsetY,
				curWidth, curHeight);
	}
}
