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
	public final TextContainer text;
	
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
		
		text = new Text("Continue.");
		nextEvent = null;
		
	}
	
	/**
	 * @param text
	 * @param arguments
	 */
	public Choice (String text, Event... arguments) {
		
		this.text = new Text(text);
		nextEvent = new EventGroup(arguments);
		
	}
	
	/**
	 * @param text
	 * @param nextEvent
	 */
	public Choice (String text, EventGroup nextEvent) {
		
		this.text = new Text(text);
		this.nextEvent = nextEvent;
		
	}
	
	/**
	 * @param text
	 * @param nextEvent
	 */
	public Choice (TextContainer text, EventGroup nextEvent) {
		
		this.text = text;
		this.nextEvent = nextEvent;
		
	}
	
	/**
	 * @return
	 */
	public Event getNextEvent () {
		
		return nextEvent.getEvent();
		
	}
	
}
