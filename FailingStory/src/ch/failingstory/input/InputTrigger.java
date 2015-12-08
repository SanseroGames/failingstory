package ch.failingstory.input;

public class InputTrigger {
	private boolean state;
	private boolean lastState;
	
	public boolean getState(){
		boolean result = state;
		state = false;
		return result;
	}
	
	public void setState(boolean value){
		if (value && value != lastState)
            state = value;
        lastState = value;
	}
}
