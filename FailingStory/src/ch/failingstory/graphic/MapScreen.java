package ch.failingstory.graphic;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.failingstory.IDrawableComponent;
import ch.failingstory.IUnit;
import ch.failingstory.MapManager;

public class MapScreen implements IDrawableComponent{

	private MapManager manager;
	private CursorRenderer cursor;
	private Animation selectedField;
	private Image grid;
	private float gridBlend;

	public MapScreen(MapManager manager) throws SlickException {
		this.manager = manager;
		cursor = new CursorRenderer(manager);
		// hardcoded reference and speed!
		
		selectedField = new Animation(new Image[] { new Image(".\\res\\selectedfield.png") }, 100);

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

		// Temp Hardcoded
		gridBlend = 0.1f;
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		int cellWidth = manager.getMap().getTileWidth();
		int cellHeight = manager.getMap().getTileHeight();

		// Draw Map
		// TODO: Dynamic Map movement
		manager.getMap().render(0, 0);
		g.drawImage(grid, 0, 0, manager.getMap().getWidth() * cellWidth, manager.getMap().getHeight() * cellHeight, 0,
				0, grid.getWidth(), grid.getHeight(), new Color(0, 0, 0, gridBlend));

		// Draw selection
		// TODO: path finder to check if cell is blocked
		if (manager.getSelectedUnit() != null) {
			drawUnitRange(cellWidth,cellHeight);
		}

		// Draw Units
		for (IUnit unit : manager.getUnits()) {
			if (unit != null)
				unit.getAnimation().draw(((int) unit.getX()) * cellWidth, ((int) unit.getY()) * cellHeight, cellWidth,
						cellHeight);
		}

		// Draw Cursor
		cursor.render(g, container);
	}
	
	private void drawUnitRange(int cellWidth, int cellHeight){
		IUnit selUnit = manager.getSelectedUnit();
		int wr = selUnit.getWalkRange();
		int xar = selUnit.getMaxAttackRange();
		int nar = selUnit.getMinAttackRange();
		for (int x = -(wr + xar); x <= wr + xar; x++) {
			for (int y = -(wr + xar - Math.abs(x)); y <= (wr + xar - Math.abs(x)); y++) {
				if (Math.abs(x) + Math.abs(y) > wr && Math.abs(x) + Math.abs(y) >= wr + nar) {
					selectedField.draw(((selUnit.getX() + x) * cellWidth) + 1,
							(selUnit.getY() + y) * cellHeight + 1, cellWidth - 2, cellHeight - 2,
							new Color(238f / 255f, 69f / 255f, 49f / 255f, 0.8f));
				} else if (Math.abs(x) + Math.abs(y) <= wr) {
					if (x != 0 || y != 0) {
						selectedField.draw(((selUnit.getX() + x) * cellWidth) + 1,
								(selUnit.getY() + y) * cellHeight + 1, cellWidth - 2, cellHeight - 2,
								new Color(36f / 255f, 126f / 255f, 248f / 255F, 0.8f));
					}
				}
			}
		}
	}

}
