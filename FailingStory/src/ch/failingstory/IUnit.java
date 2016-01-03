package ch.failingstory;

import org.newdawn.slick.Animation;

/**
 * Interface that represents a Unit
 * @author SanseroGames
 *
 */
public interface IUnit {

	/**
	 * The Name of the Unit
	 * @return Name of the Unit
	 */
	String getName();

	/**
	 * Returns to which Fraction the unit belongs
	 * @return The Fraction
	 */
	IFraction getFraction();

	/**
	 * The X-Coordinate of the Unit in MapCells
	 * @return The X-Coordinate
	 */
	int getX();
	
	/**
	 * The Y-Coordinate of the Unit in MapCells
	 * @return The Y-Coordinate
	 */
	int getY();

	/**
	 * Sets the Position of the Unit
	 * @param x - The new X-Coordinate
	 * @param y - The new Y-Coordinate
	 */
//	void setPosition(int x, int y);

	/**
	 * The Stats of the Unit
	 * @return Stats
	 */
	UnitStats getStats();
	
	/**
	 * Returns the Amout of HP the Unit has left
	 * @return Current HP
	 */
	int getHP();

	/**
	 * Changes the Value of the Unit by the specified value. This might be negative.
	 * @param value The value to add to the HP of the Unit
	 */
//	void changeHPBy(int value);

	/**
	 * Returns how far the Unit can Walk in MapCells
	 * @return The Walkrange
	 */
	int getWalkRange();

	/**
	 * 
	 * @return
	 */
	int getMaxAttackRange();
	
	/**
	 * 
	 * @return
	 */
	
	int getStrength();
	/**
	 * 
	 * @return
	 */

	int getDefense();
	/**
	 * 
	 * @return
	*/
	
	int getMinAttackRange();

	/**
	 * Shows if the Unit has finished its turn
	 * @return true if finished
	 */
	boolean hasFinished();

	/**
	 * The Animation of the Unit to Display. This may change upon specific events
	 * @return The Animation to Display
	 */
	Animation getAnimation();
}
