package ch.failingstory.simulation;

import org.newdawn.slick.Animation;

import ch.failingstory.IFraction;
import ch.failingstory.IUnit;
import ch.failingstory.UnitStats;

public abstract class Unit implements IUnit {
	
	String name;
	

	@Override
	public String getName() {
		/** gets the name of the unit */
		return name;
	}
	
	IFraction fraction;

	@Override
	public IFraction getFraction() {
		/** get the fraction of the unit */
		return fraction;
	}

	int x;
	
	@Override
	public int getX() {
		/** get (coordinate) x of the unit */
		return x;
	}
	
	int y;

	@Override
	public int getY() {
		/** get (coordinate) y of the unit */
		return y;
	}
	
	@Override
	public void setPosition(int x, int y) {
		/** set the position of the unit */
	}

	UnitStats stats;
	
	@Override
	public UnitStats getStats() {
		/** get the statistics of the unit */
		return stats;
	}

	int hp;
	
	@Override
	public int getHP() {
		/** get the health points of the unit */
		return hp;
	}
	
	@Override
	public void changeHPBy(int value) {
		/** change the health points of the unit by a specified value */
		hp += value;
		
	}

	int walkrange;
	
	@Override
	public int getWalkRange() {
		/** get the walk range of the unit */
		return walkrange;
	}

	int attackrange;
	
	@Override
	public int getAttackRange() {
		/** get the attack range of the unit */
		return attackrange;
	}
	
	boolean finished;

	@Override
	public boolean hasFinished() {
		/** has the unit finished (the turn)? */
		return finished;
	}

	Animation animation;
	
	@Override
	public Animation getAnimation() {
		/** get the animation of the unit */
		return animation;
	}

}
