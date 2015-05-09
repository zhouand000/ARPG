/**
 * 
 */
package arpg.game.events;

/**
 * @author Andrew
 * 
 */
public class Choice {
	
	/**
	 * The text of the choice
	 */
	public final String text;
	final EventList nextEvent;
	
	/**
	 * 
	 */
	public Choice () {
		// TODO Auto-generated constructor stub
		
		text = "Continue.";
		nextEvent = null; 
		
	}
	
	/**
	 * @param text
	 * @param nextEvent 
	 */
	public Choice (String text, EventList nextEvent) {
		
		this.text = text;
		this.nextEvent = nextEvent;
		
	}
	
}
