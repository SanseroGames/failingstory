package ch.failingstory.graphic;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.failingstory.DrawableComponent;
import ch.failingstory.IUnit;
import ch.failingstory.MapManager;
import ch.failingstory.ResourceManager;

public class MapScreen extends DrawableComponent{

	private MapManager manager;
	private Image grid;

	public MapScreen(MapManager manager) throws SlickException {
		this.manager = manager;

		// Draw grid (is there a nicer way?)
		grid = new Image(manager.getMap().getWidth() * manager.getMap().getTileWidth(),
				manager.getMap().getHeight() * manager.getMap().getTileHeight());
		Graphics g = grid.getGraphics();
		g.setColor(Color.black);
		int evenw = (manager.getMap().getTileWidth() - 1) % 2;
		for (int x = 0; x < manager.getMap().getWidth(); x++) {
			g.drawRect(manager.getMap().getTileWidth() * x - evenw, 0, 1,
					manager.getMap().getHeight() * manager.getMap().getTileHeight());
		}
		int evenh = (manager.getMap().getTileHeight() - 1) % 2;
		for (int y = 0; y < manager.getMap().getHeight(); y++) {
			g.drawRect(0, manager.getMap().getTileWidth() * y - evenh,
					manager.getMap().getWidth() * manager.getMap().getTileWidth(), 1);
		}
		g.flush();
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		int cellWidth = manager.getMap().getTileWidth();
		int cellHeight = manager.getMap().getTileHeight();

		// Draw Map
		// TODO: Dynamic Map movement
		manager.getMap().render(0, 0);
		g.drawImage(grid, 0, 0, manager.getMap().getWidth() * cellWidth, manager.getMap().getHeight() * cellHeight, 0,
				0, grid.getWidth(), grid.getHeight(), new Color(0, 0, 0, ResourceManager.gridBlend));

		// Draw Units
		for (IUnit unit : manager.getUnits()) {
			if (unit != null)
				unit.getAnimation().draw(((int) unit.getX()) * cellWidth, ((int) unit.getY()) * cellHeight, cellWidth,
						cellHeight);
		}
	}
}
