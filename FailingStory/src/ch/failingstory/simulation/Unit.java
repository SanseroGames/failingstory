package ch.failingstory.simulation;

import org.newdawn.slick.Animation;

import ch.failingstory.IFraction;
import ch.failingstory.IUnit;
import ch.failingstory.UnitStats;

public abstract class Unit implements IUnit {
	
	private String name;
	private IFraction fraction;
	private int x;
	private int y;
	private UnitStats stats;
	private int hp;
	private int walkrange;
	private int attackrange;
	private Animation animation;
	private boolean finished;
	
	/** private gets the name of the unit */
	@Override
	public String getName() {
		return name;
	}

	/** get the fraction of the unit */
	@Override
	public IFraction getFraction() {
		return fraction;
	}
	
	/** get (coordinate) x of the unit */
	@Override
	public int getX() {
		return x;
	}

	/** get (coordinate) y of the unit */
	@Override
	public int getY() {
		return y;
	}
	
	/** set the position of the unit */
	@Override
	public void setPosition(int x, int y) {
	}
	
	/** get the statistics of the unit */
	@Override
	public UnitStats getStats() {
		return stats;
	}
	
	/** get the health points of the unit */
	@Override
	public int getHP() {
		return hp;
	}
	
	
	/** change the health points of the unit by a specified value */
	@Override
	public void changeHPBy(int value) {
		hp += value;
		
	}
	
	/** get the walk range of the unit */
	@Override
	public int getWalkRange() {
		return walkrange;
	}
	
	/** get the attack range of the unit */
	@Override
	public int getAttackRange() {
		return attackrange;
	}

	/** has the unit finished (the turn)? */
	@Override
	public boolean hasFinished() {
		return finished;
	}
	
	/** get the animation of the unit */
	@Override
	public Animation getAnimation() {
		return animation;
	}

}
