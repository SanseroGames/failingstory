package ch.failingstory.input;

import org.newdawn.slick.GameContainer;

public class InputComponent {
	
	private MapMouseListener mouse;
	private MapKeyListener keyboard;
	private MapControllerListener controller;
	
	private RepeatedTrigger left = new RepeatedTrigger();
	private RepeatedTrigger right = new RepeatedTrigger();
	private RepeatedTrigger up = new RepeatedTrigger();
	private RepeatedTrigger down = new RepeatedTrigger();
	
	private InputTrigger interact = new InputTrigger();
	private InputTrigger back = new InputTrigger();
//	private InputTrigger zoomIn = new InputTrigger();
//	private InputTrigger zoomOut = new InputTrigger();
	
	public InputComponent(GameContainer container){
		mouse = new MapMouseListener();
		container.getInput().addMouseListener(mouse);
		keyboard = new MapKeyListener();
		container.getInput().addKeyListener(keyboard);
		controller = new MapControllerListener();
		container.getInput().addControllerListener(controller);
	}
	
	public void update(GameContainer container, int delta){
		left.setState(keyboard.isLeftPressed(), delta);
		right.setState(keyboard.isRightPressed(), delta);
		up.setState(keyboard.isUpPressed(), delta);
		down.setState(keyboard.isDownPressed(), delta);
		
		interact.setState(keyboard.isInteractPressed());
		back.setState(keyboard.isBackPressed());
	}
	
	public boolean isLeftPressed(){
		return left.getState();
	}
	
	public boolean isRightPressed(){
		return right.getState();
	}
	
	public boolean isUpPressed(){
		return up.getState();
	}
	
	public boolean isDownPressed(){
		return down.getState();
	}
	
	public boolean isInteractPressed(){
		return interact.getState();
	}
	
	public boolean isBackPressed(){
		return back.getState();
	}
	
	public boolean isMenuPressed(){
		return false;
	}
}
