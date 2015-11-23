package ch.failingstory;

public abstract class Unit implements IUnit {
	
	String Name;
	
	UnitStats Stats;
	
	int WalkRange;
	
	int AttackRange;
	
	IFraction Fraction;
	
	boolean Finished;
	
	int HP;
	
}