package ch.failingstory;

public interface IUnit {
	
	String getName();
	
	UnitStats getStats();
	
	int getWalkRange();
	
	int getAttackRange();
	
	IFraction getFraction();
	
	boolean hasFinished();
	
	int getHP();
	
	void changeHPBy(int value);
	
	
}
