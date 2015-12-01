package ch.failingstory.simulation;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class TestUnit extends Unit{

	private Animation ani;
	private String nam;
	
	public TestUnit(int x, int y, String name){
		setPosition(x,y);
		nam = name;
		try {
			ani = new Animation(new Image[] {new Image(".\\res\\testunit.png"), new Image(".\\res\\testunit1.png")},1000,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nam;
	}

	@Override
	public Animation getAnimation() {
		// TODO Auto-generated method stub
		return ani;
	}

}
