package ch.failingstory;

public abstract class Unit implements IUnit {
	
	String name;
	
	UnitStats stats;
	
	int walkrange;
	
	int attackrange;
	
	IFraction fraction;
	
	boolean finished;
	
	int hp;

	@Override
	public String getName() {
		// get the name of the unit
		return name;
	}

	@Override
	public UnitStats getStats() {
		// get the stats of the unit
		return stats;
	}

	@Override
	public int getWalkRange() {
		// get the walk range of the unit
		return walkrange;
	}

	@Override
	public int getAttackRange() {
		// get the attack range of the unit
		return attackrange;
	}

	@Override
	public IFraction getFraction() {
		// get the fraction of the unit
		return fraction;
	}

	@Override
	public boolean hasFinished() {
		// has the unit finished?
		return finished;
	}

	@Override
	public int getHP() {
		// get the health points of the unit
		return hp;
	}

	@Override
	public void changeHPBy(int value) {
		// change health points by a specified value
		hp = hp + value;
	}

}
