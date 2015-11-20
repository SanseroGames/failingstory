package ch.failingstory;

public interface IMap {
	
	/**
	 * Länge der Karte in IMapCell
	 * @return 
	 */
	int getHeight();
	
	/**
	 * Breite der Karte in IMapCell
	 * @return
	 */
	int getWidth();
	
	IMapCellDefinition getCellAt(int x, int y);
	
	void setCellDefintion(int x, int y, IMapCellDefinition definition);
}
