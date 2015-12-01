package ch.failingstory.input;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

public class MapMouseListener implements MouseListener {
	
	private boolean mouseMoved = false;
	private int mousePositionX;
	private int mousepositionY;
	
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
		mouseMoved = false;
	}

	@Override
	public void mouseWheelMoved(int change) {
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
	}

	@Override
	public void mousePressed(int button, int x, int y) {
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		mouseMoved = true;
		mousePositionX = newx;
		mousepositionY = newy;
		
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
	}

	//Getter
	
	public boolean isMouseMoved(){
		return mouseMoved;
	}
	
	public int getMouseX(){
		return mousePositionX;
	}
	
	public int getMouseY(){
		return mousepositionY;
	}
}
