package ch.failingstory.simulation;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.failingstory.UnitStats;

public class TestUnit extends Unit{

	private Animation ani;
	private String nam;
	
	public TestUnit(int x, int y, String name, int walk, int max, int min, int strength, int defense, int hp) throws SlickException{
		super(walk,max,min);

		setPosition(x,y);
		nam = name;
		this.setStats(new UnitStats(hp,strength,defense));
		changeHPBy(hp);
		ani = new Animation(new Image[] {new Image(".\\res\\testunit.png"), new Image(".\\res\\testunit1.png")},1000,true);
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
