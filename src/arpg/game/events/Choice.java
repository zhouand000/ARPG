/**
 * 
 */
package arpg.game.events;

import javax.xml.bind.annotation.*;

/**
 * @author Andrew
 * 
 */
@XmlRootElement
public class Choice {
	
	/**
	 * The text of the choice
	 */
	@XmlElement
	public final String text;
	
	/**
	 * A list of possible events
	 * 
	 */
	@XmlElementRef
	public final EventCollection nextEvent;
	
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
		nextEvent = new EventCollection(arguments);
		
	}
	
	/**
	 * @param text
	 * @param nextEvent
	 */
	public Choice (String text, EventCollection nextEvent) {
		
		this.text = text;
		this.nextEvent = nextEvent;
		
	}
	
}
