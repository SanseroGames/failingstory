package ch.failingstory.input;

public class RepeatedTrigger {
	private boolean state;
	private boolean laststate;
	private int timer;
	private int interval = 50;
	private int startInterval = 250;

	public boolean getState() {
		boolean result = state;
		state = false;
		return result;
	}

	public void setState(boolean value, int delta) {
		if (value) {
			if (timer >= interval)
				timer = 0;
			if (timer == 0){
				state = value;
				if(state != laststate){
					timer = -startInterval;
				}
				laststate = state;
			}
			timer += delta;
		} else {
			timer = 0;
			laststate = value;
		}
	}

	public void setRepeatingInterval(int value) {
		interval = value;
	}
	
	public void setStartingInterval(int value){
		startInterval = value;
	}
}
