package ch.failingstory.simulation;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class TestUnit extends Unit{

	private Animation ani;
	private String nam;
	private int str;
	private int def;
//	private int hp;
	
	public TestUnit(int x, int y, String name, int walk, int max, int min, int strength, int defense, int healthpoints){
		//Debuging constructor Call
		super(walk,max,min);

		setPosition(x,y);
		changeHPBy(healthpoints);
		//hp = healthpoints;
		str = strength;
		def = defense;
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
	
//	@Override
//	public int getHP() {
//		return hp;
//	}
	
	@Override
	public int getStrength() {
		return str;
	}
	
	@Override
	public int getDefense() {
		return def;
	}

	@Override
	public Animation getAnimation() {
		// TODO Auto-generated method stub
		return ani;
	}

}
