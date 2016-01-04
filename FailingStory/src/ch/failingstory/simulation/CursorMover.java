package ch.failingstory.simulation;

import java.util.ArrayList;

import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

import ch.failingstory.IUnit;
import ch.failingstory.Index2;

public class CursorMover{
	
	//Does that make sense?
	public static ArrayList<Index2> calculateCursorPath(int x, int y, IUnit selUnit, ArrayList<Index2> curPath, TiledMap map){
		ArrayList<Index2> output = null;
		//TODO:Cleanup this Spagetthi-code
		if(curPath != null){
			int diffX = Math.abs(selUnit.getX() - x);
			int diffY = Math.abs(selUnit.getY() - y);
			//Cursor in Range
			if(diffX + diffY <= selUnit.getWalkRange()){
				output = curPath;
				//Cursorpath to long
				if(output.size() > selUnit.getWalkRange() || output.size() == 0){
					AStarPathFinder find = new AStarPathFinder((TileBasedMap) map, selUnit.getWalkRange(), false);
					Path p = find.findPath(new EmptyMover(), selUnit.getX(), selUnit.getY(),
							x, y);
					//path found
					if(p !=null ){
						output = new ArrayList<Index2>();
						for(int i=0; i<p.getLength();i++){
							output.add(new Index2(p.getX(i),p.getY(i)));
						}
					}else{
						if(output.size()==0){
							output.add(new Index2(selUnit.getX(),selUnit.getY()));
						}
					}
				}else{
					Index2 newCell = new Index2(x,y);
					//Cell already in Path
					if(output.contains(newCell)){
						int index = output.indexOf(newCell);
						for(int i= index + 1; i < output.size();){
							output.remove(i);
						}
					}else{
						output.add(newCell);
					}
				}
			}else{
				output = new ArrayList<Index2>();
			}
		}else{
			output = new ArrayList<Index2>();
			output.add(new Index2(selUnit.getX(),selUnit.getY()));
			//May cause problems if cursor is not next to the Unit
			output.add(new Index2(x,y));
		}
		return output;
	}

}
