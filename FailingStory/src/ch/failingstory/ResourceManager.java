package ch.failingstory;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Manager for less Magic-Numbers and Hardcoded things
 * @author SanseroGames
 *
 */
public final class ResourceManager {
	
	/**
	 * Animation used to display the Range a Unit can walk or attack
	 */
	public static Image markedField;
	/**
	 * Animation for the Cursor
	 */
	public static Animation cursor;
	/**
	 * Path to the Icon for the Window
	 */
	public static String iconPath = ".\\res\\icon.png";
	
	/**
	 * Images for the arrow in the Unit-move-mode
	 */
	public static Image[] arrow ;
	
	/**
	 * The Alpha-Blending of the grid on the map.
	 */
	public static float gridBlend = 0.1f;
	
	/**
	 * Loads content that cannot be loaded with static initialization of the class
	 */
	public static void initialize(){
		try {
			markedField = new Image(".\\res\\selectedfield.png");
			cursor = new Animation(new Image[] { new Image(".\\res\\cursor1.png"), new Image(".\\res\\cursor2.png") },
					new int[] { 1000, 400 });
			arrow = new Image[] { new Image(".\\res\\arrow_left_right.png"), new Image(".\\res\\arrow_top_bottom.png"),
					new Image(".\\res\\arrow_left_bottom.png"), new Image(".\\res\\arrow_left_top.png"),
					new Image(".\\res\\arrow_right_top.png"), new Image(".\\res\\arrow_right_bottom.png"),
					new Image(".\\res\\arrow_left_right_head.png"), new Image(".\\res\\arrow_right_left_head.png"),
					new Image(".\\res\\arrow_top_bottom_head.png"), new Image(".\\res\\arrow_bottom_top_head.png") };
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Changes the Blinkspeed for the Cursor
	 * @param bigCursor Speed in milliseconds
	 * @param smallCursor Speed in milliseconds
	 */
	public static void setCursorSpeed(int bigCursor, int smallCursor){
		cursor.setDuration(0, bigCursor);
		cursor.setDuration(1, smallCursor);
	}
	
	/**
	 * Changes the Alphablend for the grid
	 * @param blend Alphablend 
	 */
	public static void setGridBlend(float blend){
		gridBlend = blend;
	}
}
