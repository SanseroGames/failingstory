package ch.failingstory.input;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class MapKeyListener implements KeyListener {

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean action;

	@Override
	public void setInput(Input input) {
	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void inputEnded() {
	}

	@Override
	public void inputStarted() {
	}

	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_LEFT){
			left = true;
		}
		if(key == Input.KEY_RIGHT){
			right = true;
		}
		if(key == Input.KEY_UP){
			up = true;
		}
		if(key == Input.KEY_DOWN){
			down = true;
		}
		if(key == Input.KEY_ENTER){
			action = true;
		}
	}

	@Override
	public void keyReleased(int key, char c) {
		if(key == Input.KEY_LEFT){
			left = false;
		}
		if(key == Input.KEY_RIGHT){
			right = false;
		}
		if(key == Input.KEY_UP){
			up = false;
		}
		if(key == Input.KEY_DOWN){
			down = false;
		}
		if(key == Input.KEY_ENTER){
			action = false;
		}
	}
	
	public boolean isLeftKeyPressed(){
		return left;
	}
	
	public boolean isRightKeyPressed(){
		return right;
	}
	
	public boolean isUpKeyPressed(){
		return up;
	}
	
	public boolean isDownKeyPressed(){
		return down;
	}
	
	public boolean isActionPressed(){
		return action;
	}

}
