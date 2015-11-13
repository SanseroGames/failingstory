package ch.failingstory;

public interface IMapCellDefinition {
	
	String getDefinitionName();
	
	int getDefenseBonus();
	
	int getMoveCost();
	
	boolean isTraversable();
}
