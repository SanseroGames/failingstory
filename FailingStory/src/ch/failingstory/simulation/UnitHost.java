package ch.failingstory.simulation;

public class UnitHost {
	
	private Unit unit;
	
	public UnitHost(Unit unit){
		this.unit = unit;
	}
	
	public Unit getUnit(){
		return unit;
	}
	
	public void attack(Unit underAttack){
		//TODO: Check if underAttack is in attackRange
		if (underAttack.getHP() <= unit.getStrength()) {
			underAttack.changeHPBy(- (underAttack.getHP()));
		}
		else if (underAttack.getHP() > unit.getStrength()) {
			underAttack.changeHPBy(-(unit.getStrength()));
		}
	}
}
