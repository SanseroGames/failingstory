package ch.failingstory;

import org.newdawn.slick.Animation;

public interface IUnit {

	String getName();

	IFraction getFraction();

	int getX();
	
	int getY();

	void setPosition(int x, int y);

	UnitStats getStats();
	
	int getHP();

	void changeHPBy(int value);

	int getWalkRange();

	int getAttackRange();

	boolean hasFinished();

	Animation getAnimation();
}
