package ch.failingstory;

public class UnitStats {
	public final int MaxHP;
	public final int Attack;
	public final int Defense;
	//TODO: more stats!
	
	public UnitStats(){
		MaxHP = 0;
		Attack = 0;
		Defense = 0;
	}
	
	public UnitStats(int maxHP, int attack, int defense){
		MaxHP = maxHP;
		Attack = attack;
		Defense = defense;
	}
}
