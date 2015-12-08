package ch.failingstory.simulation;

import org.newdawn.slick.Animation;

import ch.failingstory.*;

public abstract class Unit implements IUnit {

	private IFraction fraction;
	private int x;
	private int y;
	private UnitStats stats;
	private int hp;
	private int walkRange;
	private int minAttackRange;
	private int maxAttackRange;
	private boolean finished;

	//Temp Constructor for Debunging
	public Unit(int walk, int max, int min){
		hp = 10;
		walkRange = walk;
		minAttackRange = min;
		maxAttackRange = max;
	}
	
	@Override
	public abstract String getName();

	@Override
	public abstract Animation getAnimation();
	
	@Override
	public UnitStats getStats() {
		return stats;
	}

	@Override
	public int getWalkRange() {
		return walkRange;
	}

	@Override
	public int getMaxAttackRange() {
		return maxAttackRange;
	}
	
	@Override
	public int getMinAttackRange() {
		return minAttackRange;
	}

	@Override
	public IFraction getFraction() {
		return fraction;
	}

	@Override
	public boolean hasFinished() {
		return finished;
	}

	@Override
	public int getHP() {
		return hp;
	}

	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public int getY() {
		return y;
	}

	//Setter Methods
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void changeHPBy(int value) {
		hp += value;
	}
}
