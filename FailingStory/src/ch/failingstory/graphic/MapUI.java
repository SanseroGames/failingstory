package ch.failingstory.graphic;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.failingstory.DrawableComponent;
import ch.failingstory.IUnit;
import ch.failingstory.MapManager;
import ch.failingstory.ResourceManager;

public class MapUI extends DrawableComponent {

	private MapManager manager;
	private Animation selectedField;
	private CursorRenderer cursor;
	private Image unitRange;
	private MapScreen mapScreen;
	
	public MapUI(MapManager manager) throws SlickException{
		this.manager = manager;
		
		selectedField = ResourceManager.markedField;
		
		mapScreen = new MapScreen(manager);
		cursor = new CursorRenderer(manager);
	}
	
	 /**
	  * 
	  */
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// Draw selection
		// TODO: path finder to check if cell is blocked
		mapScreen.render(container,g);
		if (manager.getSelectedUnit() != null) {
			if(unitRange == null){
				drawUnitRange();
			}
			IUnit u = manager.getSelectedUnit();
			int x = (u.getX() + 1)* manager.getMap().getTileWidth() - (unitRange.getWidth() / 2);
			int y = (u.getY() + 1)* manager.getMap().getTileHeight() - (unitRange.getHeight() / 2);
			unitRange.draw(x,y);
		}else{
			unitRange = null;
		}
		
		cursor.render(container,g);
	}
	
	private void drawUnitRange() throws SlickException{
		IUnit selUnit = manager.getSelectedUnit();
		int cellWidth = manager.getMap().getTileWidth();
		int cellHeight = manager.getMap().getTileHeight();
		int wr = selUnit.getWalkRange();
		int xar = selUnit.getMaxAttackRange();
		int nar = selUnit.getMinAttackRange();
		unitRange = new Image(2 * (wr+xar + 1) * cellWidth, 2 * (wr+xar + 1) * cellHeight);
		Graphics g = unitRange.getGraphics();
		for (int x = -(wr + xar); x <= wr + xar; x++) {
			for (int y = -(wr + xar - Math.abs(x)); y <= (wr + xar - Math.abs(x)); y++) {
				if (Math.abs(x) + Math.abs(y) > wr && Math.abs(x) + Math.abs(y) >= wr + nar) {
					g.drawAnimation(selectedField,(((wr + xar) + x) * cellWidth) ,
							((wr + xar) + y) * cellHeight ,
							new Color(238f / 255f, 69f / 255f, 49f / 255f, 0.8f));
				} else if (Math.abs(x) + Math.abs(y) <= wr) {
					if (x != 0 || y != 0) {
						g.drawAnimation(selectedField,(((wr + xar) + x) * cellWidth) ,
								((wr + xar) + y) * cellHeight ,
								new Color(36f / 255f, 126f / 255f, 248f / 255F, 0.8f));
					}
				}
			}
		}
		g.flush();
	}
}
