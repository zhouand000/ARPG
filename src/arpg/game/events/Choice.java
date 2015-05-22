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
	
	/**
	 * A list of possible events
	 * 
	 */
	public final EventGroup nextEvent;
	
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
	 * @param arguments
	 */
	public Choice (String text, Event... arguments) {
		
		this.text = text;
		nextEvent = new EventGroup(arguments);
		
	}
	
	/**
	 * @param text
	 * @param nextEvent
	 */
	public Choice (String text, EventGroup nextEvent) {
		
		this.text = text;
		this.nextEvent = nextEvent;
		
	}
	
}
