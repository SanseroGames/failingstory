package ch.failingstory.simulation;

import org.newdawn.slick.Animation;

import ch.failingstory.*;

public abstract class Unit implements IUnit {

	private int x;
	private int y;
	private int hp;

	@Override
	public abstract String getName();

	@Override
	public abstract Animation getAnimation();
	
	@Override
	public UnitStats getStats() {
		return new UnitStats();
	}

	@Override
	public int getWalkRange() {
		return 4;
	}

	@Override
	public int getMaxAttackRange() {
		return 5;
	}
	
	@Override
	public int getMinAttackRange() {
		return 2;
	}

	@Override
	public IFraction getFraction() {
		return null;
	}

	@Override
	public boolean hasFinished() {
		return false;
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
