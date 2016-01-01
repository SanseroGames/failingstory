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

public class MapUI extends DrawableComponent {

	private MapManager manager;
	private Image selectedField;
	private CursorRenderer cursor;
	private MapScreen mapScreen;
	
	public MapUI(MapManager manager) throws SlickException{
		this.manager = manager;
		
		selectedField = ResourceManager.markedField;
		
		mapScreen = new MapScreen(manager);
		cursor = new CursorRenderer(manager);
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// Draw selection
		// TODO: path finder to check if cell is blocked
		mapScreen.render(container,g);
		if (manager.getSelectedUnit() != null) {
			IUnit u = manager.getSelectedUnit();
			drawRange(g,u.getX(),u.getY(),u.getMinAttackRange() + u.getWalkRange(),u.getMaxAttackRange() + u.getWalkRange(),new Color(238f / 255f, 69f / 255f, 49f / 255f, 0.8f));
			drawRange(g,u.getX(),u.getY(),0,u.getWalkRange(),new Color(36f / 255f, 126f / 255f, 248f / 255F, 0.8f));
		}else{
			
		}
		// Draw Units
		for (IUnit unit : manager.getUnits()) {
			if (unit != null)
				unit.getAnimation().draw(((int) unit.getX()) * manager.getMap().getTileWidth(), ((int) unit.getY()) * manager.getMap().getTileHeight(),
						manager.getMap().getTileWidth(), manager.getMap().getTileHeight());
		}
		cursor.render(container,g);
	}
	
	/**
	 * Renders 
	 * @param g
	 * @param unitX
	 * @param unitY
	 * @param walkRange
	 * @param maxAttack
	 * @param minAttack
	 * @throws SlickException
	 */
	private void drawRange(Graphics g, int unitX, int unitY, int minRange, int maxRange, Color col) throws SlickException{		
		int cellWidth = manager.getMap().getTileWidth();
		int cellHeight = manager.getMap().getTileHeight();

		
		for (int x = -maxRange; x <= maxRange; x++){
			for (int y = -maxRange; y <= maxRange; y++){
				if(Math.abs(x) + Math.abs(y) <= maxRange &&
						Math.abs(x) + Math.abs(y) >= minRange &&
						(x != 0 || y != 0)){
					g.drawImage(selectedField,(((unitX - (maxRange)) + (maxRange) + x) * cellWidth) ,
						((unitY - (maxRange)) + (maxRange) + y) * cellHeight , col);
				}
			}
		}
		
//		
//		for (int x = -(wr + xar); x <= wr + xar; x++) {
//			for (int y = -(wr + xar - Math.abs(x)); y <= (wr + xar - Math.abs(x)); y++) {
//				if (Math.abs(x) + Math.abs(y) > wr && Math.abs(x) + Math.abs(y) >= wr + nar) {
//					g.drawImage(selectedField,(((ux - (wr + xar)) + (wr + xar) + x) * cellWidth) ,
//							((uy - (wr + xar)) + (wr + xar) + y) * cellHeight ,
//							new Color(238f / 255f, 69f / 255f, 49f / 255f, 0.8f));
//				} else if (Math.abs(x) + Math.abs(y) <= wr) {
//					if (x != 0 || y != 0) {
//						g.drawImage(selectedField,(((ux - (wr + xar)) + (wr + xar) + x) * cellWidth) ,
//								((uy - (wr + xar)) + (wr + xar) + y) * cellHeight ,
//								new Color(36f / 255f, 126f / 255f, 248f / 255F, 0.8f));
//					}
//				}
//			}
//		}
	}
}
