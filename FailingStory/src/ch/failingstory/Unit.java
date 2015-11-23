package ch.failingstory;

public abstract interface Unit extends IUnit {
	
	String Name();
	
	UnitStats Stats();
	
	int WalkRange();
	
	int AttackRange();
	
	IFraction Fraction();
	
	boolean Finished();
	
	int HP();
	
}
