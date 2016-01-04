package ch.failingstory.simulation;

import org.newdawn.slick.Animation;

import ch.failingstory.*;

public abstract class Unit implements IUnit{

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
		walkRange = walk;
		minAttackRange = min;
		maxAttackRange = max;
		stats = new UnitStats();
	}
	
	@Override
	public abstract String getName();

	@Override
	public abstract Animation getAnimation();
	
	@Override
	public final UnitStats getStats() {
		return stats;
	}
	
	protected final void setStats(UnitStats stats){
		this.stats = stats;
	}

	@Override
	public final int getWalkRange() {
		return walkRange;
	}

	@Override
	public final int getMaxAttackRange() {
		return maxAttackRange;
	}
	
	@Override
	public final int getMinAttackRange() {
		return minAttackRange;
	}

	@Override
	public final IFraction getFraction() {
		return fraction;
	}
	
	@Override
	public final int getStrength() {
		return stats.Attack;
	}

	@Override
	public final int getDefense() {
		return stats.Defense;
	}

	@Override
	public final boolean hasFinished() {
		return finished;
	}

	@Override
	public final int getHP() {
		return hp;
	}

	@Override
	public final int getX() {
		return x;
	}
	
	@Override
	public final int getY() {
		return y;
	}

	//Setter Methods
	
	public final void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public final void changeHPBy(int value) {
		if(hp + value >= stats.MaxHP){
			hp = stats.MaxHP;
		}else{
			hp += value;
		}
	}
}
