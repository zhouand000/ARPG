/**
 * 
 */
package arpg.game.events;

import arpg.game.effects.StatusEffect;

/**
 * Basic events prototype
 * 
 * @author Andrew
 * 
 */
public class EventRandomizer {
	
	public EventCollection events = new EventCollection();
	
	/**
	 * The location of the events folder
	 */
	public static final String eventsFolderLocation = "arpg/assets/events/";
	
	/**
	 * 
	 */
	public EventRandomizer () {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public void initEventlist () {
		
		events.add(
				new Event ("Temple", "You arrive at a temple. There are two doors.",
						new Choice("Enter the left door.", new Event("You are hit by a poisoned arrow.", new StatusEffect(""))))
				);
		
	}
	
}
