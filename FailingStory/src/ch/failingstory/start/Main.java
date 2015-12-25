package ch.failingstory.start;

public class Main {

	/**
	 * Start method
	 */
	public static void main(String[] args) {
		try{
			StartGame game = new StartGame("The Failing Story Reaktor");
			game.run();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
