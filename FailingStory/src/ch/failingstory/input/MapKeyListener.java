package ch.failingstory.input;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class MapKeyListener implements KeyListener, IInputSet {

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean interact;
	private boolean back;
	
	private boolean inputAccepted;
	
	public MapKeyListener(){
		this(true);
	}
	
	public MapKeyListener(boolean activateInput){
		inputAccepted = activateInput;
	}

	@Override
	public void setInput(Input input) {
	}

	@Override
	public boolean isAcceptingInput() {
		return inputAccepted;
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
			interact = true;
		}
		if(key == Input.KEY_ESCAPE)
			back = true;
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
			interact = false;
		}
		if(key == Input.KEY_ESCAPE)
			back = false;
	}

	@Override
	public boolean isLeftPressed() {
		return left;
	}

	@Override
	public boolean isRightPressed() {
		return right;
	}

	@Override
	public boolean isUpPressed() {
		return up;
	}

	@Override
	public boolean isDownPressed() {
		return down;
	}

	@Override
	public boolean isInteractPressed(){
		return interact;
	}
	
	@Override
	public boolean isBackPressed() {
		return back;
	}

}
