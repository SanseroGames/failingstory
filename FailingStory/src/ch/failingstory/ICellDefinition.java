package ch.failingstory;

public interface ICellDefinition {
	
	String getDefinitionName();
	
	int getDefenseBonus();
	
	int getMoveCost();
	
	boolean isTraversable();
}
