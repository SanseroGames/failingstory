package ch.failingstory.input;

import org.newdawn.slick.GameContainer;

public class InputComponent {
	
	private MapMouseListener mouse;
	private MapKeyListener keyboard;
	private MapControllerListener controller;
	
	private boolean lastLeft;
	private boolean left;
	private boolean lastRight;
	private boolean right;
	private boolean lastUp;
	private boolean up;
	private boolean lastDown;
	private boolean down;
	
	private boolean lastAction;
	private boolean action;
	private boolean lastBack;
	private boolean back;
	
	public InputComponent(GameContainer container){
		mouse = new MapMouseListener();
		container.getInput().addMouseListener(mouse);
		keyboard = new MapKeyListener();
		container.getInput().addKeyListener(keyboard);
		controller = new MapControllerListener();
		container.getInput().addControllerListener(controller);
	}
	
	public void update(GameContainer container, int delta){
		left = keyboard.isLeftKeyPressed();
		right = keyboard.isRightKeyPressed();
		up = keyboard.isUpKeyPressed();
		down = keyboard.isDownKeyPressed();
		
		boolean t = keyboard.isActionPressed();
		if (t != lastAction){
			action = t;
		}
		lastAction = t;
	}
	
	public boolean isLeftPressed(){
		return left;
	}
	
	public boolean isRightPressed(){
		return right;
	}
	
	public boolean isUpPressed(){
		return up;
	}
	
	public boolean isDownPressed(){
		return down;
	}
	
	public boolean isActionPressed(){
		boolean t = action;
		action = false;
		return t;
	}
	
	public boolean isBackPressed(){
		return back;
	}
	
	public boolean isMenuPressed(){
		return false;
	}
}
